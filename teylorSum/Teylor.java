package teylorSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sayko on 03.09.2015.
 */
public class Teylor {

    private double numberE;
    private int numberK;
    private double numberX;

    public void readerNumber() throws IOException, NumberFormatException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number K: ");

        do{
            numberK = Integer.parseInt(reader.readLine());
        }while(numberK < 0);

        do{
            System.out.print("Enter number X(-1 < x < 1): ");
            numberX = Double.parseDouble(reader.readLine());
        }while (numberX < -1 || numberX > 1);
        numberE = Math.pow(10, -numberK);
    }

    public double sumTeylor(){

        double sumNumber = 1;
        double i = 1;
        double a = 1;
        double summand = 1;

        while(Math.abs(summand) > numberE){
            a *= i/(i + 1);
            summand = Math.pow(-1, i)*a*Math.pow(numberX, i);
            sumNumber += summand;
            i++;
        }

        return sumNumber;
    }

    public double sumStandardLib(){
        return 1/(Math.sqrt(1 + numberX));
    }

    public void equal(){
        double a = sumTeylor();
        double b = sumStandardLib();

        if(a > b){
            System.out.println(a + " > "+b);
        }
        else{
            if(a < b){
                System.out.println(a+" < "+b);
            }
            else{
                System.out.println(a+" = "+b);
            }
        }
    }
}