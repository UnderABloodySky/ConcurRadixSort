package radixSort;

import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import threadPool.AddMonitor;
import threadPool.ConvenientBarrier;
import threadPool.ThreadPool;

public class ConcurRadixSort {
	private ThreadPool myThreadPool;
	private int quantityThreads;
	private List<Integer> result;
	//private List<Integer> listSort;
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
			ConvenientBarrier convenientBarrier=new ConvenientBarrier(cantThreads);
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
			RadixSortTask radixsorttask=new RadixSortTask(idtask, from, to, result, bit,onesAndZeros, convenientBarrier,addMonitor);
			myThreadPool.launch(radixsorttask); 
			from =to+1;
			}
		convenientBarrier.waiting();
		this.aplanate(onesAndZeros); 
		}
		return result;
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
		List<Integer> listSort=new ArrayList<>();
		TreeMap<Integer,List<List<Integer>>> ordOnesAndZeros=new TreeMap<>(onesAndZeros);
		Set<Map.Entry<Integer,List<List<Integer>>>> iterOnesAndZeros=ordOnesAndZeros.entrySet();
		
		for(Map.Entry<Integer, List<List<Integer>>> it:iterOnesAndZeros) {
			listSort.addAll(it.getValue().get(0));
		}
		for(Map.Entry<Integer, List<List<Integer>>> it:iterOnesAndZeros) {
			listSort.addAll(it.getValue().get(1));
		}
		
		result=listSort;
		//	aca todo va a result
	}
}
