package teylorSum;

import java.io.IOException;

/**
 * Created by Sayko on 03.09.2015.
 */
public class MainTeylorSum {
    public static void main(String[] args){
        Teylor teylor = new Teylor();

        try {
            teylor.readerNumber();
            System.out.print("standard: ");
            System.out.printf("%8.3f\n", teylor.sumStandardLib());

            System.out.print("sum: ");
            System.out.printf("%8.3f\n", teylor.sumTeylor());

            teylor.equal();

        }catch (IOException e){
            e.printStackTrace();
        }catch (NumberFormatException e){
            System.out.println("incorrect format number!");
        }

    }

}

