package company.fileRead;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Sayko on 11.11.2015.
 */
public class CheckData {

    public String checkDate(Date date) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("d MMMM yyyy", Locale.ENGLISH);

        return format.format(date);
    }

}
