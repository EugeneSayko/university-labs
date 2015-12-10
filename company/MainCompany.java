package company;

import company.fileRead.CheckData;
import company.fileRead.FileReadJSON;
import company.fileRead.ReadingDataFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

/**
 * Created by Sayko on 31.10.2015.
 */
public class MainCompany {

    public static void main(String[] args){
        Log.updateFile();
        Log.in("run application");

        Menu menu = new Menu();
        try {
            menu.run();
        } catch (IOException e) {
            System.out.println("error");
            Log.in("error IOException");
        } catch (ParseException e) {
            System.out.println("error parse date");
            Log.in("error ParseException");
        }catch (NumberFormatException e){
            System.out.println("error number format");
            Log.in("error NumberFormatException");
        }catch (IllegalArgumentException e){
            System.out.println("error format");
            Log.in("error IllegalArgumentException");
        }

        Log.in("exit application");
    }

}
