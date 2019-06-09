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

   // public void radixSort(List<Integer> listToSort) {
    //     List<Integer> aux = this.radix(listToSort);
    //    listToSort = aux;
    //
    //}

    public void radixSort(List<Integer> listToSort) {
        result = listToSort;
        for (int bit = 0; bit < 32; bit++) {
            ConvenientBuffer onesAndZeros = new ConvenientBuffer(quantityThreads);
            this.generateRadixSortTasks(result, bit, onesAndZeros);
            result = onesAndZeros.aplanate();
       }
        System.out.println("Finalmente la lista ordenada es: ");
        for(Integer elem : result){
            System.out.println(elem);
        }
        myThreadPool.stop();
    }

    private void generateRadixSortTasks(List<Integer> listToSort, int bit, ConvenientBuffer onesAndZeros) {
        for(Integer elem : listToSort){
            System.out.println(elem);
        }

        int count = 0;
        RadixTaskFactory factory = new  RadixTaskFactory();
        while(count<quantityThreads){
            RadixSortTask radixTask = factory.createRadixTask(listToSort, bit, onesAndZeros);
            myThreadPool.launch(radixTask);
            count++;
        }
    }
}
