package threadSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sayko on 10.12.2015.
 */
public class MainSort {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the dimensions of the array: ");
            int size = Integer.parseInt(reader.readLine());
            List<Integer> list = new ArrayList<>();
            Random random = new Random();
            for(int i = 0; i < size; i++){
                list.add(random.nextInt(1000));
            }
            System.out.println("size array - "+list.size());
            for(int item : list){
                System.out.print(item + " ");
            }
            System.out.println();
            menuitem();
            int item = Integer.parseInt(reader.readLine());
            Thread thread = new Thread(new Sort(list, item));
            thread.start();
            thread.join();
            System.out.println("sorted array: ");
            for(int i : list){
                System.out.print(i + " ");
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void menuitem(){
        System.out.println("1.sort ascending values");
        System.out.println("2.Sort descending values");
        System.out.println("3.sort ascending number of digits");
        System.out.println("4.sort descending number of digits");
        System.out.print("Choose: ");
    }
}
