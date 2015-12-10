package sqlQuery;

import sqlQuery.FileRead.ReadFileCSV;
import sqlQuery.FileRead.ReadFileJSON;
import sqlQuery.FileRead.ReadFileXML;
import sqlQuery.FileRead.SqlReadFile;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sayko on 09.12.2015.
 */
public class Processing {

    private Companies companies;
    private ReadFileJSON readFileJSON;
    private ReadFileXML readFileXML;
    private List<Company> companyList;
    private SqlReadFile sqlReadFile;

    public Processing(){
        companies = new Companies();
        readFileJSON = new ReadFileJSON();
        readFileXML = new ReadFileXML();
        companyList = new ArrayList<>();
        sqlReadFile = new SqlReadFile();
    }

    public void run() throws FileNotFoundException, ParseException {
        LogSqlQuery.inFile("run process requests");
        ReadFileCSV readFileCSV = new ReadFileCSV();
        readFileCSV.readingFile(FileName.fileInput, companies);
        sqlReadFile.readFile(FileName.fileNameSql);
        search();
    }

    private void search() throws ParseException {
        int i = 1;
        LogSqlQuery.inFile("start search requests");
        for(String item : sqlReadFile.getSqlList()){
            check(item);
            LogSqlQuery.inFile("Record results request" + i + ".json");
            readFileJSON.writeFile("request" + i + ".json", companyList);
            LogSqlQuery.inFile("Record results request" + i + ".xml");
            readFileXML.writeFile("request" + i + ".xml", companyList);
            i++;
            companyList.clear();
        }
    }

    private void check(String str){

        if(str.matches(".*(from database).*")){

            String where = sqlReadFile.getWhere(str);

            if(where.matches(".*shorttitle.*")){
                LogSqlQuery.inFile("Processing the request to find short title");
                searchTitle(where);
                return;
            }

            if(where.matches(".*activity.*")){
                LogSqlQuery.inFile("Processing the request to find activity");
                searchActivity(where);
                return;
            }

            if(where.matches(".*employees.*")){
                LogSqlQuery.inFile("Processing the request to find count employees");
                searchEmployees(where);
                return;
            }
        }else{
            LogSqlQuery.inFile("such table exists");
        }


    }

    private void searchTitle(String str){
        String title = str.substring(str.indexOf('\'') + 1, str.lastIndexOf('\''));
        companyList.addAll(companies.searchTitle(title));
    }

    private void searchActivity(String str){
        String title = str.substring(str.indexOf('\'') + 1, str.lastIndexOf('\''));
        companyList.addAll(companies.searchActivity(title));
    }

    private void searchEmployees(String str){
        String line = str.substring(str.indexOf("between") + 7, str.length()).trim();
        int min = Integer.parseInt(line.substring(0, line.indexOf("and")).trim());
        int max = Integer.parseInt(line.substring(line.indexOf("and") + 3, line.length()).trim());

        if(min > 0 && max > 0){
            companyList.addAll(companies.searchEmployees(min, max));
        }
    }
}
