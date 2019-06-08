package radixSort;

//import java.util.ArrayList;
import java.util.List;

import threadPool.ThreadPool;

public class ConcurRadixSort {
    private ThreadPool myThreadPool;
    private int quantityThreads;
    private List<Integer> result;
    private ConvenientBarrier convenientBarrier;

    public ConcurRadixSort(int bufferSize, int _quantityThreads) {
        myThreadPool = new ThreadPool(bufferSize, _quantityThreads);
        quantityThreads = _quantityThreads;
        convenientBarrier = new ConvenientBarrier(quantityThreads);;
        result = null;
    }

    public void radixSort(List<Integer> listToSort) {
        this.radix(listToSort);
        //Hay que esperar que terminen para maar todos los procesos
        //myThreadPool.stop();
    }

    private void radix(List<Integer> listToSort) {
        System.out.println("Empieza radix");
        result = listToSort;
        for (int bit = 0; bit < 32; bit++) {
            System.out.println("Bit ->" + bit);

            ConvenientBuffer onesAndZeros = new ConvenientBuffer(quantityThreads);
            this.generateRadixSortTasks(listToSort, bit, onesAndZeros);
            System.out.println("Una instrucciondespues del generate ->");
            result = onesAndZeros.aplanate();
            System.out.println("Una instrucciondespues del aplanate ->");
            for(Integer elem : listToSort){
                System.out.println(elem);
            }
        }
    }

	/*
	//Revisar esto
	private synchronized void generateRadixSortTasks(List<Integer> listToSort, int bit, ConvenientBuffer onesAndZeros) {
		int count = 0;
		int from = 0;
		int to = 0;
		int id = 0;
		while (count < quantityThreads) {
			to = (listToSort.size()/quantityThreads)-1;
			RadixSortTask radixTask = new RadixSortTask(id, from, to, result, bit, onesAndZeros, convenientBarrier);
			id++;
			int dif= from - to;
			from = to + 1;
			to = from + dif;
			count++;
			myThreadPool.launch(radixTask);
		}
	}
*/

    private void generateRadixSortTasks(List<Integer> listToSort, int bit, ConvenientBuffer onesAndZeros) {
        for(Integer elem : listToSort){
            System.out.println(elem);
        }

        int count = 0;
        RadixTaskFactory factory = new  RadixTaskFactory();
        while(count<quantityThreads){
            System.out.println("Count -> " + count);
            RadixSortTask radixTask = factory.createRadixTask(listToSort, bit, onesAndZeros, convenientBarrier);
            System.out.println("ID -> " + radixTask.id());
            System.out.println("from -> " + radixTask.from());
            System.out.println("To ->" + radixTask.to());
            myThreadPool.launch(radixTask);
            count++;
        }
        System.out.println("Fin generateRadix");
    }
}
