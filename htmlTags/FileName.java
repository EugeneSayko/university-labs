package htmlTags;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Sayko on 28.10.2015.
 */
public class FileName {
    private static final String PROPERTIES_FILE = "src/htmlTags/filesName.properties";

    public static String fileNameInputHTML;
    public static String fileNameSearchFragments;
    public static String fileNameOutputTegs;
    public static String fileNameOutputLines;
    public static String fileNameOutputFragments;

    static{
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(PROPERTIES_FILE);
            properties.load(fileInputStream);

            fileNameInputHTML = properties.getProperty("file_name_input_html");
            fileNameSearchFragments = properties.getProperty("file_name_search_fragments");
            fileNameOutputTegs = properties.getProperty("file_name_output_tegs");
            fileNameOutputLines = properties.getProperty("file_name_output_lines");
            fileNameOutputFragments = properties.getProperty("file_name_output_fragments");

        } catch (FileNotFoundException e) {
            System.out.println("file not found error");
        } catch (IOException e) {
            System.out.println("file error");
        }finally {
            try {
                fileInputStream.close();
            }catch (IOException e){
                System.out.println("file close error");
            }
        }
    }
}
