package sqlQuery;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Sayko on 31.10.2015.
 */
public class FileName {

    private static final String FILE_PROPERTIES = "src/sqlQuery/filesName.properties";

    public static String fileNameLog;
    public static String fileNameSql;
    public static String directory;
    public static String fileInput;
    public static String nameTable;

    static {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(FILE_PROPERTIES);
            properties.load(fileInputStream);

            fileNameLog = properties.getProperty("file_name_log");
            fileNameSql = properties.getProperty("file_name_sql");
            directory = properties.getProperty("files_directory");
            fileInput = properties.getProperty("file_input");
            nameTable = properties.getProperty("name_table");

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
