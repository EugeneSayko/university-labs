package htmlTags;

import htmlTags.FileName;
import htmlTags.FileRead;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Sayko on 29.10.2015.
 */
public class ProccesingHtmlTag {

    private FileRead fileRead;
    private String textHtml;
    private Map<String, Boolean> fragments;
    private String textDeleteTags;

    public ProccesingHtmlTag(){
        fileRead = new FileRead();
        fragments = new HashMap<String, Boolean>();
    }

    public void readText() throws IOException, FileNotFoundException {
        textHtml = fileRead.readFile(FileName.fileNameInputHTML).toString();
        deleteTegs();
    }

    private void deleteTegs(){
        textDeleteTags = Pattern.compile("(<.*?>)").matcher(textHtml).replaceAll("");
    }

    public void readFragments() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(FileName.fileNameSearchFragments));
        scanner.useDelimiter("[;]");

        while(scanner.hasNext()){
            fragments.put(scanner.next(), false);
        }
    }

    private int numberLineFragment(String fragment){
        int index = textDeleteTags.toLowerCase().indexOf(fragment);
        int line = 0;
        for(int i = 0; i < index; i++){
            if(textDeleteTags.charAt(i) == '\n'){
                line++;
            }
        }
        return line;
    }

    public void searchFragment(){
        Set<String> set = fragments.keySet();
        StringBuilder numberLineFragment = new StringBuilder("");
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String item : set){
            if(checkFragment(item)){
                fragments.replace(item, true);
                map.put(item, numberLineFragment(item));
            }else{
                map.put(item, -1);
            }
        }

        outputNumberLine(map);
        outputFragmentNoSearch();

    }

    private boolean checkFragment(String fragment){
        String str = textDeleteTags.toLowerCase();
        return str.contains(fragment);
    }

    private void outputNumberLine(Map<String, Integer> map){
        StringBuilder sb = new StringBuilder("");

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            sb.append(entry.getKey() + " - " + entry.getValue());
            sb.append("\n");
        }

        fileRead.writeTextFile(sb.toString(), FileName.fileNameOutputLines);
    }

    private void outputFragmentNoSearch(){
        StringBuilder stringBuilder = new StringBuilder("");

        for(Map.Entry<String, Boolean> entry : fragments.entrySet()){
            if(entry.getValue() == false){
                stringBuilder.append(entry.getKey());
                stringBuilder.append("\n");
            }
        }

        fileRead.writeTextFile(stringBuilder.toString(), FileName.fileNameOutputFragments);
    }

    public void searchTags(){
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < textHtml.length(); i++){
            if(textHtml.charAt(i) == '<' && textHtml.charAt(i + 1) != '/'){
                int j = 0;
                for(j = i + 1; textHtml.charAt(j) != '>'; j++){
                    sb.append(textHtml.charAt(j));
                }
                i = j;
                list.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        StringBuilder sbOutput = new StringBuilder("");

        for(String item : list){
            sbOutput.append("<"+ item + ">" + " - " + item.length());
            sbOutput.append("\n");
        }

        fileRead.writeTextFile(sbOutput.toString(), FileName.fileNameOutputTegs);
    }
}
