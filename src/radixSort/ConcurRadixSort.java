package radixSort;

import threadPool.ThreadPool;

public class ConcurRadixSort {
    private ThreadPool myThreadPool;
    public ConcurRadixSort(int bufferSize, int quantityThreads){
        myThreadPool = new ThreadPool(bufferSize,quantityThreads);
    }

    public int[] radixSort(int[] listToSort){
        return listToSort;
    }
}
