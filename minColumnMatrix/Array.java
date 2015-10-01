package minColumnMatrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Sayko on 09.09.2015.
 */
public class Array {

    private int n;
    private int sizeRow;
    private int sizeColumn;
    private int[][] array;
    private ArrayList<Integer> arrayMinNumberColums;
    private BufferedReader reader;

    private int minMulColumn;

    public Array(){
        reader = new BufferedReader(new InputStreamReader(System.in));
        arrayMinNumberColums = new ArrayList<Integer>();
    }

    public void inputSizes() throws NumberFormatException{

        try {

            System.out.println("Enter the number n: ");
            n = Integer.parseInt(reader.readLine());

            System.out.println("Enter the number of rows(greater 0): ");

            do {
                sizeRow = Integer.parseInt(reader.readLine());
            }while (sizeRow <= 0);

            System.out.println("Enter the number of colums(greater 0): ");

            do {
                sizeColumn = Integer.parseInt(reader.readLine());
            }while (sizeColumn <= 0);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inputElements() throws NumberFormatException{

        System.out.println("Enter elements of array: ");

        try {

            int q = 0;
            array = new int[sizeRow][sizeColumn];

            for(int i = 0; i < sizeRow; i++){
                for(int j = 0; j < sizeColumn;){
                    q = Integer.parseInt(reader.readLine());
                    if(Math.abs(q) < n){
                        array[i][j] = q;
                        j++;
                    }else{
                        System.out.println("array element must be less than n!");
                    }
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void printArray(){

        for(int[] a : array){
            for(int b : a){
                System.out.print(b + " ");
            }
            System.out.println("");
        }

    }

    public void searchMinColumns(){

        int min = 1;
        int minColumn = 1;

        try {

            for (int i = 0; i < sizeRow; i++) {
                min *= array[i][0];
            }

            for (int i = 1; i < sizeColumn; i++) {
                for (int j = 0; j < sizeRow; j++) {
                    minColumn *= array[j][i];
                }

                if (minColumn <= min) {
                    min = minColumn;
                    arrayMinNumberColums.add(i + 1);
                }

                minColumn = 1;
            }

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("error index array!");
        }

        minMulColumn = min;
    }

    public void printMinNumberColums(){
        System.out.print("column numbers: ");
        for(int a : arrayMinNumberColums){
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public int getMinMulColumn() {
        return minMulColumn;
    }
}
