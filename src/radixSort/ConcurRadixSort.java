package radixSort;

import threadPool.Task;
import threadPool.ThreadPool;

public class ConcurRadixSort {
    private ThreadPool myThreadPool;

    public ConcurRadixSort(int bufferSize, int quantityThreads){
        myThreadPool = new ThreadPool(bufferSize,quantityThreads);
    }

    public int[] radixSort(int[] listToSort){

        return listToSort;
    }


    private  synchronized void generateTasks(int n){
        int count = 0;
        while(count <=n){
            myThreadPool.launch(new RadixSortTask());
        }
    }
}
