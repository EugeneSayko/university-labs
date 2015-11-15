package company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Sayko on 31.10.2015.
 */
public class FileName {

    private static final String FILE_PROPERTIES = "src/company/filesName.properties";

    public static String fileNameLog;
    public static String fileNameCompanies;
    public static String outputJSON;
    public static String outputXML;

    static {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(FILE_PROPERTIES);
            properties.load(fileInputStream);

            fileNameLog = properties.getProperty("file_name_log");
            fileNameCompanies = properties.getProperty("companies_list");
            outputJSON = properties.getProperty("output_JSON");
            outputXML = properties.getProperty("output_XML");

        }catch (IOException e){
            System.err.println("error propeties file!");
        }finally {
            try {
                fileInputStream.close();
            }catch (IOException e){
                System.err.println("error close file");
            }
        }
    }

}
