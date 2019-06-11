package radixSort;

import threadPool.ThreadPool;

import java.util.List;

public class RadixTaskFactory {
    private Counter counter;
    private int from;
    private int to;
    private ConcurRadixSort myConcurRadixSort;

    public RadixTaskFactory(ConcurRadixSort aConcurRadixSort){
        myConcurRadixSort = aConcurRadixSort;
        counter = new  Counter();
        from = 0;
        to = 9;
    }

    /*
    *  int x = list.size();
        int n = 7;
        int count = 0;
        int from = 0;
        int to = 0;

    * */

    public void createRadixTasks(List<Integer> listToSort, int quantitythreads, int bit, ConvenientBuffer onesAndZeros){
        int x = listToSort.size();
        int n = quantitythreads;
        int from = 0;
        int to = 0;
            while (0 < n) {
                int y = x / n;
                if ((x % n) != 0) {
                y++;
                }
                x -= y;
                n--;
                to += y;
                RadixSortTask task = this.createRadixTask(listToSort, from, to, bit, onesAndZeros);
                myConcurRadixSort.launchRadixTask(task);
                from = to;
        }
    }

    private RadixSortTask createRadixTask(List<Integer> listToSort, int from, int to, int bit, ConvenientBuffer onesAndZeros) {
        RadixSortTask task = new RadixSortTask(this.id(), from, to, listToSort, bit, onesAndZeros);
        return task;
    }

    private int id(){
        return counter.value();
    }
}



