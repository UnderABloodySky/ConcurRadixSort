package radixSort;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import threadPool.ThreadPool;

public class ConcurRadixSort {
	private ThreadPool myThreadPool;
	private int quantityThreads;
	private List<Integer> result;

	public ConcurRadixSort(int bufferSize, int _quantityThreads) {
		myThreadPool = new ThreadPool(bufferSize, _quantityThreads);
		quantityThreads = _quantityThreads;
		result = null;
	}

	public void radixSort(List<Integer> listToSort) {
		result = listToSort;
		this.radix(result);
		myThreadPool.stop();
	}

	private void generateRadioSortTasks(List<Integer> listToSort, int bit) {
		int count = 0;
		int to = 0;
		int from = listToSort.size() / quantityThreads - 1;
		while (count < quantityThreads) {
			int dif;
			RadixSortTask radixTask = new RadixSortTask(to, from, result, bit);
			dif = from - to;
			to = from + 1;
			from = dif;
			myThreadPool.launch(radixTask);
		}
	}

	private void radix(List<Integer> listToSort) {
		for (int i = 0; i < 32; i++) {
			this.generateRadioSortTasks(listToSort, i);
		}
	}
}
