package sqlQuery;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Sayko on 03.12.2015.
 */
public class Main {

    public static void main(String[] args){
        LogSqlQuery.updateFile();
        LogSqlQuery.inFile("run application");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        LogSqlQuery.inFile("application start time: " + dateFormat.format(date));
        try {
            Processing processing = new Processing();
            processing.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LogSqlQuery.inFile("error file not found exception");
        } catch (ParseException e) {
            e.printStackTrace();
            LogSqlQuery.inFile("error parse exception");
        }
        LogSqlQuery.inFile("end application");
        LogSqlQuery.inFile("time of completion of the program: " + dateFormat.format(date));


    }

}
