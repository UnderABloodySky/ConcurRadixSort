package radixSort;

import java.util.List;

public class RadixTaskFactory {
    private Counter counter;
    private int from;
    private int to;

    public RadixTaskFactory(){
        counter = new  Counter();
        from = 0;
        to = 5;
    }

    //FALTA CALCULAR BIEN EL FROM Y EL TO
    public RadixSortTask createRadixTask(List<Integer> listToSort, int bit, ConvenientBuffer onesAndZeros) {
        RadixSortTask task = new RadixSortTask(this.id(), from, to, listToSort, bit, onesAndZeros);
        from = to;
        to = listToSort.size();
        return task;
    }

    private int id(){
        return counter.value();
    }
}



