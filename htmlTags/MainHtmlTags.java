package htmlTags;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Sayko on 28.10.2015.
 */
public class MainHtmlTags {

    public static void main(String[] args){

        ProccesingHtmlTag proccesingHtmlTag = new ProccesingHtmlTag();
        try {
            proccesingHtmlTag.readText();
            proccesingHtmlTag.readFragments();
            proccesingHtmlTag.searchTags();
            proccesingHtmlTag.searchFragment();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
