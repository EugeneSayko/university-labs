package htmlTags;

import java.io.*;

/**
 * Created by Sayko on 28.10.2015.
 */
public class FileRead {

    public StringBuilder readFile(String fileName) throws IOException, FileNotFoundException{
        StringBuilder text = new StringBuilder("");
        String line;
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while((line = reader.readLine()) != null){
            text.append(line);
            text.append("\n");
        }

        return text;
    }

    public void writeTextFile(String str, String fileName){
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                PrintStream printStream = new PrintStream(fileOutputStream);
                ){

            printStream.print(str);

        }catch (IOException e){
            System.out.println("error write text in file");
        }
    }
}
