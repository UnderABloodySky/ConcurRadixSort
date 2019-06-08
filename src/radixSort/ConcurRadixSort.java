package radixSort;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import threadPool.ThreadPool;

public class ConcurRadixSort {
	private ThreadPool myThreadPool;
	private int quantityThreads;
	private List<Integer> result;
	private List<Integer> listSort;
	private int cantThreads;
	private AddMonitor addMonitor;

	public ConcurRadixSort(int bufferSize, int _quantityThreads) {
		myThreadPool = new ThreadPool(bufferSize, _quantityThreads);
		quantityThreads = _quantityThreads;
		result = null;
	}

	public List<Integer> radixSort(List<Integer> listToSort) {
		result = listToSort;
		//this.radix(result);
		//Para terminar las tareas debo asegurarme que ya la lista esta terminada.
		// Tengo que esperar. Ver semaforo o barrera
		//myThreadPool.stop();
		cantThreads=quantityThreads;
		for (int bit = 0; bit < 32; bit++){
			addMonitor= new AddMonitor();
//			aca va la barrera;
			Map<Integer,List<List<Integer>>> onesAndZeros= new HashMap<>();
			int ultimo=listToSort.size()-1;//porq es un array
			int from=0;
			int to=-1;
//		aca paso los id a los task para asegurar el ordenamiento
		for(int idtask=1;idtask<cantThreads+1;idtask++){
			to=(listToSort.size()/cantThreads)+to;
			if((cantThreads-idtask)==0){
				to=ultimo;//para cuando me queda impar
				}
			new RadixSortTask(idtask, from, to, result, bit,onesAndZeros, convenientBarrier,addMonitor);
			from =to+1;
			}
//		aca va la barrera
		this.aplanate(onesAndZeros); 
		}
		return result=listSort;
	}

//	private void generateRadioSortTasks(int bit, List<List<Integer>> onesAndZeros) {
//		int count = 0;
//		int from = 0;
//		int to = result.size() / quantityThreads - 1;
//		while (count < quantityThreads) {
//			int dif;
//			RadixSortTask radixTask = new RadixSortTask(from, to, result, bit, onesAndZeros);
//			dif = from - to;
//			to = from + 1;
//			from = dif;
//			myThreadPool.launch(radixTask);
//		}
//	}
//
//	private void radix(List<Integer> result) {
//		for (int bit = 0; bit < 32; bit++) {
//			List<List<Integer>> onesAndZeros = new ArrayList<>();
//			this.generateRadioSortTasks(bit, onesAndZeros);//Esta parte hay que secuencilizar.
//			// Para que el task que  considerando el (i+1)-esimo bit pueda dar el resultado de su split,
//			// la task que considera el i-esimo bit debe haber ya guardado su resultado.
//			// Tengo que esperar. Ver semaforo o barrera
//			this.aplanate(onesAndZeros);
//		}
//	}

	private void aplanate(Map<Integer,List<List<Integer>>> onesAndZeros){
//	aca todo va a listsort
	}
}
