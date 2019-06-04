package radixSort;

import threadPool.Task;

import java.util.ArrayList;
import java.util.List;

public class RadixSortTask extends Task {
    private int myFrom;
    private int myTo;
    private List<Integer> listToOrder;
    private List<Integer> result;

    public RadixSortTask(int from, int to, List<Integer> list, List<Integer> result){
        myFrom = from;
        myTo = to;
        listToOrder = list;
        result = new ArrayList<>();
    }

    @Override
    public void run(){
        List<Integer> result= new ArrayList<>();
            for (int i = 0; i < 32; ++i) {
                //result= this.split(listToOrder, i);
            }
            listToOrder = result;
    }

    private List<List<Integer>> split(List<Integer> listToSplit ,int i) {
        List<Integer> zeros = new ArrayList<Integer>();
        List<Integer> ones = new ArrayList<Integer>();
        List<List<Integer>> result= new ArrayList();
        int mask = 1 << i;
        for (int num : listToSplit) {
            if (mask == (num & mask) ) {
                ones.add(num);
            }
            else {
                zeros.add(num);
            }
        }
        result.add(zeros);
        result.add(ones);
        return result;
    }

}
