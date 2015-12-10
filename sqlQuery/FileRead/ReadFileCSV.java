package sqlQuery.FileRead;

import sqlQuery.Companies;
import sqlQuery.Company;
import sqlQuery.FileName;
import sqlQuery.LogSqlQuery;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sayko on 03.12.2015.
 */
public class ReadFileCSV implements ReadFile {

    @Override
    public void readingFile(String fileName, Companies companies) throws FileNotFoundException {
        LogSqlQuery.inFile("reading data from the file");
        Scanner scanner = new Scanner(new File(fileName));
        while(scanner.hasNextLine()){
            Scanner sc = new Scanner(scanner.nextLine());
            sc.useDelimiter(";");
            Company company = new Company(sc.next(), sc.next(), sc.next(), sc.next(), new Date(sc.next()), sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
            companies.addCompany(company);
        }
    }


    @Override
    public void writeFile(String fileName, List<Company> companyList){
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(new File(FileName.directory+fileName));
                PrintStream printStream = new PrintStream(fileOutputStream);
                ) {

            if(companyList.size() != 0){
                for(Company item : companyList){
                    printStream.println(writeFormatFile(item));
                }
            }else{
                printStream.println("no search");
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private StringBuilder writeFormatFile(Company company){
        StringBuilder sb = new StringBuilder();
        sb.append(company.getName());
        sb.append(";");
        sb.append(company.getShortTitle());
        sb.append(";");
        sb.append(company.getDateUpdate());
        sb.append(";");
        sb.append(company.getAddress());
        sb.append(";");
        sb.append(company.getDateFoundation());
        sb.append(";");
        sb.append(company.getCountEmployees());
        sb.append(";");
        sb.append(company.getAuditor());
        sb.append(";");
        sb.append(company.getPhone());
        sb.append(";");
        sb.append(company.getEmail());
        sb.append(";");
        sb.append(company.getBranch());
        sb.append(";");
        sb.append(company.getActivity());
        sb.append(";");
        sb.append(company.getInternetAddress());
        return sb;
    }
}
