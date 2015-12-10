package FileWork;

import java.io.IOException;

/**
 * Created by Sayko on 06.12.2015.
 */
public class SplitFile {
    public static void split(String filename, FileBytes fileBytes, int but, String formatFile) throws IOException {
        if(fileBytes.openInputFile(filename)){
            int i = 0;
            while(fileBytes.canReadFile()){
                if(fileBytes.openOutputFile("output"+i+formatFile)){
                    fileBytes.writeBytesFile(fileBytes.readButBytes(but));
                    fileBytes.closeOutputFile();
                    i++;
                }
            }
            fileBytes.closeInputFile();
        }
    }
}
