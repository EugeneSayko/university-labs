package sqlQuery.FileRead;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import sqlQuery.Companies;
import sqlQuery.Company;
import sqlQuery.FileName;

import java.io.*;
import java.util.List;

/**
 * Created by Sayko on 03.12.2015.
 */
public class ReadFileJSON implements ReadFile {

    @Override
    public void readingFile(String filename, Companies companies) {

    }

    @Override
    public void writeFile(String filename, List<Company> companyList) {
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(new File(FileName.directory+filename));
                PrintStream printStream = new PrintStream(fileOutputStream);
        ) {

            if(companyList.size() != 0){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                printStream.println(gson.toJson(companyList));
            }else{
                printStream.println("no search");
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
