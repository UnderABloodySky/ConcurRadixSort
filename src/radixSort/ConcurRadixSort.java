package radixSort;

import java.util.List;
import threadPool.ThreadPool;

public class ConcurRadixSort {
    private ThreadPool myThreadPool;
    private int quantityThreads;
    private List<Integer> result;

    public ConcurRadixSort(int bufferSize, int _quantityThreads) {
        myThreadPool = new ThreadPool(bufferSize, _quantityThreads);
        quantityThreads = _quantityThreads;
    }

    public List<Integer> radixSort(List<Integer> listToSort) {
        List<Integer> aux = this.radix(listToSort);
        myThreadPool.stop();
        return aux;
    }

    public List<Integer> radix(List<Integer> listToSort) {
        result = listToSort;
        for (int bit = 0; bit < 32; bit++) {
            ConvenientBuffer onesAndZeros = new ConvenientBuffer(quantityThreads);
            this.generateRadixSortTasks2(result, bit, onesAndZeros);
            result = onesAndZeros.aplanate();
       }
        return result;
    }
    private void generateRadixSortTasks2(List<Integer> listToSort, int bit, ConvenientBuffer onesAndZeros) {
        RadixTaskFactory factory = new  RadixTaskFactory(this);
        factory.createRadixTasks(listToSort, quantityThreads, bit, onesAndZeros);
    }

    public void launchRadixTask(RadixSortTask aTask){
        myThreadPool.launch(aTask);
    }
}


    /*
    private void generateRadixSortTasks(List<Integer> listToSort, int bit, ConvenientBuffer onesAndZeros) {
        int count = 0;
        RadixTaskFactory factory = new  RadixTaskFactory();
        while(count<quantityThreads){
            RadixSortTask radixTask = factory.createRadixTask(listToSort, bit, onesAndZeros);
            myThreadPool.launch(radixTask);
            count++;
        }
    }
*/
