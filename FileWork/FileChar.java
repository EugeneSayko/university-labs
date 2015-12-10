package FileWork;

import java.io.*;

/**
 * Created by Sayko on 05.12.2015.
 */
public class FileChar {
    private BufferedReader reader;
    private PrintStream printStream;

    public boolean openInputFile(String filename){
        try {
            reader = new BufferedReader(new FileReader(new File(filename)));
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public boolean openOutputFile(String filename){
        try {
            printStream = new PrintStream(new FileOutputStream(new File(filename)));
            return true;
        }catch (FileNotFoundException e){
            return false;
        }
    }

    public void closeInputFile() throws IOException {
        if(reader != null){
            reader.close();
        }
    }

    public void closeOutputFile() throws IOException{
        if(reader != null){
            reader.close();
        }
    }

    public StringBuilder readTextStringBuilder() throws IOException{
        String line;
        StringBuilder sb = new StringBuilder();
        while((line = reader.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }
        return sb;
    }

    public String readTextString() throws IOException{
        String line;
        String text = "";
        while((line = reader.readLine()) != null){
            text = text.concat(line);
            text = text.concat("\n");
        }
        return text;
    }

    public void writeText(String text){
        printStream.println(text);
    }

    public void writeText(StringBuilder sb){
        printStream.println(sb.toString());
    }
}
