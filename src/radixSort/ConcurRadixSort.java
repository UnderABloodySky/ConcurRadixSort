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
		result = listToSort;
		this.radix(listToSort);
		//myThreadPool.stop();
	}

	private void radix(List<Integer> listToSort) {
		for (int bit = 0; bit < 32; bit++) {
			ConvenientBuffer onesAndZeros = new ConvenientBuffer(quantityThreads);
			this.generateRadioSortTasks(listToSort, bit, onesAndZeros);
			// Ya no necesito esto si  convenientBarrier.waiting();
			result = onesAndZeros.aplanate(bit);
		}
	}

	/*
	//Revisar esto
	private synchronized void generateRadioSortTasks(List<Integer> listToSort, int bit, ConvenientBuffer onesAndZeros) {
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

	private void generateRadioSortTasks(List<Integer> listToSort, int bit, ConvenientBuffer onesAndZeros) {
		int count = 0;
		RadixTaskFactory factory = new  RadixTaskFactory();
		while(count<quantityThreads){
			RadixSortTask radixTask = factory.createRadixTask(listToSort, bit, onesAndZeros, convenientBarrier);
			myThreadPool.launch(radixTask);
		}
	}
}
