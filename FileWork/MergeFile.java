package FileWork;

import java.io.IOException;

/**
 * Created by Sayko on 06.12.2015.
 */
public class MergeFile {
    public static void merge(String filename, FileBytes fileBytes, String formatFile) throws IOException {
        int i = 0;
        if(fileBytes.openOutputFile(filename)){
            while (fileBytes.openInputFile("output"+i+formatFile)){
                fileBytes.writeBytesFile(fileBytes.readAllFile());
                fileBytes.closeInputFile();
                i++;
            }
            fileBytes.closeOutputFile();
        }
    }
}
