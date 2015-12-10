package sqlQuery.FileRead;

import sqlQuery.LogSqlQuery;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sayko on 09.12.2015.
 */
public class SqlReadFile {

    private List<String> sqlList;

    public SqlReadFile(){
        sqlList = new ArrayList<>();
    }

    public void readFile(String filename) throws FileNotFoundException {
        LogSqlQuery.inFile("read requests");
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()){
            sqlList.add(scanner.nextLine().toLowerCase());
        }
    }

    public String getWhere(String str){
        int i = str.indexOf("where");
        String where = str.substring(i + 6, str.indexOf(';'));
        return where;
    }

    public List<String> getSqlList(){
        return sqlList;
    }

}
