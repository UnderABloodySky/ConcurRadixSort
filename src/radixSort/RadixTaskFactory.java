package radixSort;

import java.util.List;

public class RadixTaskFactory {
    private Counter counter;
    private int from;
    private int to;
    private int dif;
    private int id;


    public RadixTaskFactory(){
        counter = new  Counter();
        id = counter.value();
    }

    public RadixSortTask createRadixTask(List<Integer> listToSort, int bit, ConvenientBuffer onesAndZeros, ConvenientBarrier convenientBarrier) {
        RadixSortTask task = new RadixSortTask(id, from, to, listToSort, bit, onesAndZeros, convenientBarrier);

        return task;
    }
}
