package threadSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Sayko on 10.12.2015.
 */
public class Sort implements Runnable {

    private List<Integer> list;
    private int type;

    public Sort(List<Integer> list, int type){
        this.list = list;
        this.type = type;
    }

    @Override
    public void run() {
        switch (type){
            case 1:
                Collections.sort(list, new ComporatorIncrease());
                break;
            case 2:
                Collections.sort(list, new ComporatorDecrease());
                break;
            case 3:
                Collections.sort(list, new ComporatorIncreaseCountNum());
                break;
            case 4:
                Collections.sort(list, new ComporatorDecreaseCountNum());
                break;
        }

    }
}

class ComporatorIncrease implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}

class ComporatorDecrease implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

class ComporatorIncreaseCountNum implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return String.valueOf(o1).length() - String.valueOf(o2).length();
    }
}

class ComporatorDecreaseCountNum implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return String.valueOf(o2).length() - String.valueOf(o1).length();
    }
}