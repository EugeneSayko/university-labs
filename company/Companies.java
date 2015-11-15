package company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sayko on 06.11.2015.
 */
public class Companies {

    private List<Company> companies;

    public Companies(){
        companies = new ArrayList<>();
    }

    public void addCompany(Company company){
        companies.add(company);
    }

    public List<Company> searchTitle(String title){
        List<Company> list = new ArrayList<>();

        title = title.toLowerCase();

        Log.in("search for all companies");

        for(Company item : companies){
            if(item.getShortTitle().toLowerCase().equals(title)){
                list.add(item);
            }
        }
        return list;
    }

    public List<Company> searchEmployees(int min, int max){
        List<Company> list = new ArrayList<>();

        Log.in("search for all companies");
        for(Company item : companies){
            if(item.getCountEmployees() >= min && item.getCountEmployees() <= max){
                list.add(item);
            }
        }
        return list;
    }

    public List<Company> searchBranch(String branch){
        List<Company> list = new ArrayList<>();

        branch = branch.toLowerCase();

        Log.in("search for all companies");
        for(Company item : companies){
            if(item.getBranch().toLowerCase().equals(branch)){
                list.add(item);
            }
        }
        return list;
    }

    public List<Company> searchActivity(String activity){
        List<Company> list = new ArrayList<>();

        activity = activity.toLowerCase();

        Log.in("search for all companies");
        for(Company item : companies){
            if(item.getActivity().toLowerCase().equals(activity)){
                list.add(item);
            }
        }
        return list;
    }

    public List<Company> searchDate(Date min, Date max){
        List<Company> list = new ArrayList<>();

        Log.in("search for all companies");
        for(Company item : companies){
            if(!min.after(item.getDateFoundation()) && max.after(item.getDateFoundation())){
                list.add(item);
            }
        }
        return list;
    }

    public List<Company> getCompanies(){
        Log.in("selection of all companies");
        return companies;
    }
}
