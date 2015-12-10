package sqlQuery.FileRead;


import sqlQuery.Companies;
import sqlQuery.Company;
import sqlQuery.FileName;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Sayko on 09.12.2015.
 */
public class ReadFileXML implements ReadFile {
    @Override
    public void readingFile(String filename, Companies companies) throws FileNotFoundException {

    }

    @Override
    public void writeFile(String fileName, List<Company> companies) throws ParseException{

        try(
                FileOutputStream fileOutputStream = new FileOutputStream(FileName.directory+fileName);
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

    private StringBuilder writeFormatFile(Company company) throws ParseException {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<company>\n");
        stringBuilder.append(insertDividers("name", company.getName()));
        stringBuilder.append(insertDividers("shortTitle", company.getShortTitle()));
        stringBuilder.append(insertDividers("dateUpdate", company.getDateUpdate()));
        stringBuilder.append(insertDividers("address", company.getAddress()));
        stringBuilder.append(insertDividers("dateFoundation", company.getDateFoundation().toString()));
        stringBuilder.append(insertDividers("countEmployees", ""+company.getCountEmployees()));
        stringBuilder.append(insertDividers("auditor", company.getAuditor()));
        stringBuilder.append(insertDividers("phone", company.getPhone()));
        stringBuilder.append(insertDividers("email", company.getEmail()));
        stringBuilder.append(insertDividers("branch", company.getBranch()));
        stringBuilder.append(insertDividers("activity", company.getActivity()));
        stringBuilder.append(insertDividers("internetAddress", company.getInternetAddress()));
        stringBuilder.append("</company>\n");

        return stringBuilder;
    }

    private StringBuilder insertDividers(String name, String str){
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append("<");
        sb.append(name);
        sb.append(">");
        sb.append(str);
        sb.append("</");
        sb.append(name);
        sb.append(">\n");
        return sb;
    }
}
