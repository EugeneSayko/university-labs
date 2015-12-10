package sqlQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sayko on 03.12.2015.
 */
public class Companies {

    private List<Company> companies;

    public Companies(){
        companies = new ArrayList<>();
    }

    public void addCompany(Company company) {
        companies.add(company);
    }

    public List<Company> searchTitle(String title){
        LogSqlQuery.inFile("Search companies short title");
        List<Company> list = new ArrayList<>();
        for(Company item : companies){
            if(item.getShortTitle().toLowerCase().equals(title)){
                list.add(item);
            }
        }
        return list;
    }

    public List<Company> searchEmployees(int min, int max){
        LogSqlQuery.inFile("Search companies count employees");
        List<Company> list = new ArrayList<>();

        for(Company item : companies){
            if(item.getCountEmployees() >= min && item.getCountEmployees() <= max){
                list.add(item);
            }
        }
        return list;
    }

    public List<Company> searchActivity(String activity){
        LogSqlQuery.inFile("Search companies activity");
        List<Company> list = new ArrayList<>();

        activity = activity.toLowerCase();

        for(Company item : companies){
            if(item.getActivity().toLowerCase().equals(activity)){
                list.add(item);
            }
        }
        return list;
    }

    public List<Company> getCompanies(){
        return companies;
    }


}
