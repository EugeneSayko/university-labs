package company.fileRead;

import company.Company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Sayko on 06.11.2015.
 */
public class FileReadJSON extends ReadingDataFile{

    private CheckData checkData;

    public FileReadJSON(){
        checkData = new CheckData();
    }

    protected StringBuilder writeFormatFile(Company company) throws ParseException {
        StringBuilder stringBuilder = new StringBuilder("");

        stringBuilder.append("{"+"\n");
        stringBuilder.append(insertDividers("name", company.getName())+",\n");
        stringBuilder.append(insertDividers("shortTitle", company.getShortTitle())+",\n");
        stringBuilder.append(insertDividers("dateUpdate", company.getDateUpdate()) + ",\n");
        stringBuilder.append(insertDividers("address", company.getAddress()) + ",\n");
        stringBuilder.append(insertDividers("dateFoundation", checkData.checkDate(company.getDateFoundation())) + ",\n");
        stringBuilder.append(insertDividers("countEmployees", ""+company.getCountEmployees()) + ",\n");
        stringBuilder.append(insertDividers("auditor", company.getAuditor()) + ",\n");
        stringBuilder.append(insertDividers("phone", company.getPhone()) + ",\n");
        stringBuilder.append(insertDividers("email", company.getEmail()) + ",\n");
        stringBuilder.append(insertDividers("branch", company.getBranch()) + ",\n");
        stringBuilder.append(insertDividers("activity", company.getActivity()) + ",\n");
        stringBuilder.append(insertDividers("internetAddress", company.getInternetAddress()) + "\n");

        stringBuilder.append("}");

        return stringBuilder;
    }

    protected StringBuilder insertDividers(String name, String str){
        StringBuilder sb = new StringBuilder();

        sb.append("\t");
        sb.append("\"");
        sb.append(name);
        sb.append("\": ");
        sb.append("\"");
        sb.append(str);
        sb.append("\"");

        return sb;
    }
}
