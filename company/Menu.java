package company;

import company.fileRead.FileReadJSON;
import company.fileRead.FileReadXML;
import company.fileRead.ReadingDataFile;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sayko on 11.11.2015.
 */
public class Menu {

    private Companies companies;
    private BufferedReader reader;
    private List<Company> companyList;
    private FileReadJSON fileReadJSON;
    private FileReadXML fileReadXML;

    public Menu(){
        companies = new Companies();
        reader = new BufferedReader(new InputStreamReader(System.in));
        companyList = new ArrayList<>();
        fileReadJSON = new FileReadJSON();
        fileReadXML = new FileReadXML();
    }

    public void run() throws IOException, NumberFormatException, ParseException, IllegalArgumentException {
        Log.in("run menu");
        ReadingDataFile readingDataFile = new ReadingDataFile();
        Log.in("reading data from the file");
        readingDataFile.readFile(FileName.fileNameCompanies, companies);

        menuItems();
        System.out.print("Choose: ");
        int item = Integer.parseInt(reader.readLine());
        Log.in("menu selection");
        switch (item){
            case 1:
                searchTitle();
                break;
            case 2:
                searchBranch();
                break;
            case 3:
                searchActivity();
                break;
            case 4:
                searchDate();
                break;
            case 5:
                searchCountEmployees();
                break;
            case 6:
                companyList = companies.getCompanies();
                break;
            default:
                System.out.println("no item menu");
                break;
        }
        writeFile();
    }

    private void menuItems(){
        System.out.println("menu: ");
        System.out.println("1. search title");
        System.out.println("2. search branch");
        System.out.println("3. search activity");
        System.out.println("4. search date foundation");
        System.out.println("5. search count employees");
        System.out.println("6. print all company");
    }

    private void searchTitle() throws IOException {
        Log.in("start search title");
        System.out.print("Enter title: ");
        String title = reader.readLine();
        companyList = companies.searchTitle(title);
    }

    private void searchBranch() throws IOException {
        Log.in("start search branch");
        System.out.print("Enter branch: ");
        String branch = reader.readLine();
        companyList = companies.searchBranch(branch);
    }

    private void searchActivity() throws IOException{
        Log.in("start search activity");
        System.out.print("Enter activity: ");
        String activity = reader.readLine();
        companyList = companies.searchActivity(activity);
    }

    private void searchDate() throws IOException {
        Log.in("start search date");
        System.out.print("Enter min date(for example - 01 January 1970): ");

        Date minDate = new Date(reader.readLine());
        System.out.println(minDate);
        System.out.print("Enter max date(format - d m y): ");
        Date maxDate = new Date(reader.readLine());
        companyList = companies.searchDate(minDate, maxDate);
    }

    private void searchCountEmployees() throws IOException, NumberFormatException {
        Log.in("start search count employees");
        System.out.println("Enter min count employees: ");
        int min = Integer.parseInt(reader.readLine());
        if(min < 0) throw new IllegalArgumentException();
        System.out.println();
        System.out.println("Enter max count employees: ");
        int max = Integer.parseInt(reader.readLine());
        companyList = companies.searchEmployees(min, max);
    }

    private void writeFile() throws ParseException {
        Log.in("writing search results to a file json");
        fileReadJSON.writeFile(FileName.outputJSON, companyList);
        fileReadXML.writeFile(FileName.outputXML, companyList);
    }
}
