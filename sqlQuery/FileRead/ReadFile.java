package sqlQuery.FileRead;

import sqlQuery.Companies;
import sqlQuery.Company;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Sayko on 09.12.2015.
 */
public interface ReadFile {
    void readingFile(String filename, Companies companies) throws FileNotFoundException;
    void writeFile(String filename, List<Company> companyList) throws ParseException;
}
