package stringEdit;

import java.io.IOException;

/**
 * Created by Sayko on 23.09.2015.
 */
public class MainStringEdit {
    public static void main(String[] args){
        StringEdit a = new StringEdit();
        try {
            a.inputNumberK();
            a.inputString();
            a.deleteWords();
            a.printString();
        }catch (IOException e){
            e.printStackTrace();
        }catch (NumberFormatException e){
            System.out.println("error number format");
        }
    }
}
