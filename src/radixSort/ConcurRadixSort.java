package radixSort;

//import java.util.ArrayList;
import java.util.List;

import threadPool.ThreadPool;

public class ConcurRadixSort {
    private ThreadPool myThreadPool;
	private int quantityThreads;

	public ConcurRadixSort(int bufferSize, int _quantityThreads){
        myThreadPool = new ThreadPool(bufferSize, _quantityThreads);
		quantityThreads = _quantityThreads;
    }

    /* Version feliz: 1 solo thread:
    public List<Integer> radixSort ( List<Integer> listToSort ) {
    	List<Integer> result= listToSort;
    	for (int i = 0; i < 32; ++i) {
	    	result=this.split(result, i);
    	}
    	return result ;
    }
	public List<Integer> split (List<Integer> listToSplit ,int i) {
    	List<Integer> zeros = new ArrayList<Integer>();
    	List<Integer> ones = new ArrayList<Integer>();
    	List<Integer> result= new ArrayList<Integer>();
    	int mask = 1 << i;
    	for (int num : listToSplit ) {
    		if (mask == (num & mask) ) {
    			ones.add(num);
  		}
    		else {
    			zeros.add(num);
    		}
    	}
    	result.addAll(zeros);
    	result.addAll(ones);
    	return result;
    	}
     */

	public void radixSort(List<Integer> listToSort) {
		generateRadioSortTasks(listToSort);
		myThreadPool.stop();
	}

	private void generateRadioSortTasks(List<Integer> listToSort){
		int quantityTasks = 1;
		int count = 0;
		while(count < quantityTasks){
			RadixSortTask radixTask = new RadixSortTask(count, 0,listToSort.size()-1 ,listToSort);
			myThreadPool.launch(radixTask);
			count++;
		}
	}
}
