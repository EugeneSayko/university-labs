package company.fileRead;

import company.Company;

import java.text.ParseException;

/**
 * Created by Sayko on 12.11.2015.
 */
public class FileReadXML extends ReadingDataFile {

    private CheckData checkData;

    public FileReadXML(){
        checkData = new CheckData();
    }

    protected StringBuilder writeFormatFile(Company company) throws ParseException{
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<company>\n");
        stringBuilder.append(insertDividers("name", company.getName()));
        stringBuilder.append(insertDividers("shortTitle", company.getShortTitle()));
        stringBuilder.append(insertDividers("dateUpdate", company.getDateUpdate()));
        stringBuilder.append(insertDividers("address", company.getAddress()));
        stringBuilder.append(insertDividers("dateFoundation", checkData.checkDate(company.getDateFoundation())));
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

    protected StringBuilder insertDividers(String name, String str){
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
