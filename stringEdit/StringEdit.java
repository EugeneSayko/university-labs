package stringEdit;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sayko on 24.09.2015.
 */
public class StringEdit {

    private ArrayList<String> listString;
    private int k;
    private BufferedReader reader;

    public StringEdit(){
        listString = new ArrayList<String>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void inputNumberK()throws IOException, NumberFormatException{

        System.out.println("Enter the number K( k > 0): ");

        do {
            k = Integer.parseInt(reader.readLine());
        }while (k < 0);

    }

    public void inputString() throws IOException{

        System.out.println("Enter text:");
        String str;
        do{
            str = reader.readLine();
            listString.add(str);
        }while(str.length() != 0);

    }

    public void deleteWords(){

        Iterator<String> iterator = listString.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            ArrayList<String> listLine = new ArrayList<>(Arrays.asList(str.split("[\\s,.]+")));
            if(k >= listLine.size()){
                iterator.remove();
            }else{
                Iterator<String> item = listLine.iterator();
                int i = 0;
                while(i < k){
                    String a = item.next();
                    item.remove();
                    i++;
                }

                String words = listToStr(listLine);
                replaceElem(str, words);
            }

        }
    }

    private String listToStr(List<String> al){

        StringBuilder stringBuilder = new StringBuilder();

        for(String item : al){
            stringBuilder.append(item);
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    private void replaceElem(String str, String strReplace){
        for(int i = 0; i < listString.size(); i++) {
            if (listString.get(i).equals(str)) {
                listString.set(i, strReplace);
                break;
            }

        }

    }

    public void printString(){
        for(String str : listString){
            System.out.println(str);
        }
    }
}