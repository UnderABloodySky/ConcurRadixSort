package radixSort;

import threadPool.Task;

import java.util.ArrayList;
import java.util.List;

public class RadixSortTask extends Task {
    private int myID;
    private int myFrom;
    private int myTo;
    private List<Integer> listToOrder;
    private List<Integer> result;

    public RadixSortTask(int id, int from, int to, List<Integer> list){
        myID = id;
        myFrom = from;
        myTo = to;
        listToOrder = list;
        result = new ArrayList<>();
    }

    @Override
    public void run(){
        List<Integer> result= new ArrayList<>();
            for (int i = 0; i < 32; ++i) {
                result= this.split(listToOrder, i);
            }
            listToOrder = result;
    }

    private List<Integer> split(List<Integer> listToSplit ,int i) {
        List<Integer> zeros = new ArrayList<Integer>();
        List<Integer> ones = new ArrayList<Integer>();
        List<Integer> result= new ArrayList<Integer>();
        int mask = 1 << i;
        for (int num : listToSplit) {
            if (mask == (num & mask) ) {
                ones.add(num);
            }
            else {
                zeros.add(num);
            }
        }
        result.addAll(zeros);
        result.addAll(ones);
        return result;
    }

}
