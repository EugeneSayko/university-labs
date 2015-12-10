package sqlQuery;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Sayko on 31.10.2015.
 */
public class LogSqlQuery {

    public static void inFile(String text){
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(FileName.fileNameLog, true);
                PrintStream printStream = new PrintStream(fileOutputStream);
                ){
            fileOutputStream.write(0);
            printStream.println(text);

        }catch (IOException e){
            System.err.println("error in text to log!");
        }
    }

    public static void updateFile(){
        File file = new File(FileName.fileNameLog);
        file.delete();
    }

}
