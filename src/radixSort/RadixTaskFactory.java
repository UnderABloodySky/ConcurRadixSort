package radixSort;

import java.util.List;

//FALTA CALCULAR BIEN EL FROM Y EL TO

public class RadixTaskFactory {
    private Counter counter;
    private int from;
    private int to;
    private int dif;


    public RadixTaskFactory(){
        counter = new  Counter();
        from = 0;
        to = -1;
        dif = 0;
    }

    public RadixSortTask createRadixTask(List<Integer> listToSort, int bit, ConvenientBuffer onesAndZeros, ConvenientBarrier convenientBarrier) {
        to = to +  100;
        RadixSortTask task = new RadixSortTask(this.id(), from, to, listToSort, bit, onesAndZeros, convenientBarrier);
        from = to + from + 1;
        return task;
    }

    private int id(){
        return counter.value();
    }
}
