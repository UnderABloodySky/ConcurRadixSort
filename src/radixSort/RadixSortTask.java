package radixSort;

import threadPool.Task;

import java.util.ArrayList;
import java.util.List;

public class RadixSortTask extends Task {
    private int myFrom;
    private int myTo;
    private int myBit;
    private List<Integer> myResult;

    public RadixSortTask(int from, int to, List<Integer> result, int bit){
        myFrom = from;
        myTo = to;
        myBit = bit;
        myResult = result;
    }

    @Override
    public void run(){
        List<List<Integer>> mySplit = this.split(myResult, myBit);
        myResult.addAll(mySplit.get(0));
        myResult.addAll(mySplit.get(1));
    }

    private List<List<Integer>> split(List<Integer> list ,int i) {
        List<Integer> listToSplit = list.subList(myTo, myFrom);
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
