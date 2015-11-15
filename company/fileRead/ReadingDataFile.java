package company.fileRead;

import company.Company;
import company.Companies;

import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sayko on 08.11.2015.
 */
public class ReadingDataFile {

    public void readFile(String fileName, Companies companies) throws FileNotFoundException, ParseException{

        Scanner scanner = new Scanner(new File(fileName));

        while(scanner.hasNextLine()){
            Scanner sc = new Scanner(scanner.nextLine());
            sc.useDelimiter(";");

            Company company = new Company(sc.next(), sc.next(), sc.next(), sc.next(), new Date(sc.next()), sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
            companies.addCompany(company);
        }

        scanner.close();
    }
    public void writeFile(String fileName, List<Company> companies) throws ParseException{

        try(
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                PrintStream printStream = new PrintStream(fileOutputStream);
        ){

            if(companies.size() != 0){
                for(Company item : companies){
                    printStream.println(writeFormatFile(item));
                }
            }else{
                printStream.println("no search");
            }


        }catch (IOException e){
            System.out.println("error write text in file");
        }
    }

    protected StringBuilder writeFormatFile(Company company) throws ParseException {
        StringBuilder strCompany = new StringBuilder("");
        return strCompany;
    }

}
