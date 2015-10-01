package minColumnMatrix;

/**
 * Created by Sayko on 09.09.2015.
 */
public class Main {
    public static void main(String[] args){
        Array array = new Array();

        try{
            array.inputSizes();
            array.inputElements();
            array.printArray();
            array.searchMinColumns();
            array.printMinNumberColums();
            System.out.println("mul column elements: " + array.getMinMulColumn());
        }catch (NumberFormatException e){
        System.out.println("invalid number");
        }
    }
}
