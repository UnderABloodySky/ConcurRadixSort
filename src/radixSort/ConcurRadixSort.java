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
		//Para terminar las tareas debo asegurarme que ya la lista esta terminada.
		// Tengo que esperar. Ver semaforo o barrera
		myThreadPool.stop();
	}

	private void generateRadioSortTasks(int bit, List<List<Integer>> onesAndZeros) {
		int count = 0;
		int from = 0;
		int to = result.size() / quantityThreads - 1;
		while (count < quantityThreads) {
			int dif;
			RadixSortTask radixTask = new RadixSortTask(from, to, result, bit, onesAndZeros);
			dif = from - to;
			to = from + 1;
			from = dif;
			myThreadPool.launch(radixTask);
		}
	}

	private void radix(List<Integer> result) {
		for (int bit = 0; bit < 32; bit++) {
			List<List<Integer>> onesAndZeros = new ArrayList<>();
			this.generateRadioSortTasks(bit, onesAndZeros);//Esta parte hay que secuencilizar.
			// Para que el task que  considerando el (i+1)-esimo bit pueda dar el resultado de su split,
			// la task que considera el i-esimo bit debe haber ya guardado su resultado.
			// Tengo que esperar. Ver semaforo o barrera
			this.aplanate(onesAndZeros);
		}
	}

	private List<Integer> aplanate(List<List<Integer>> onesAndZeros){
		// onesAndZeros seria algo del tipo:
		// [ [zeros bit0] , [ones bit0] ,  [zeros bit2] , [ones bit2] .. [zeros bit 31] , [ones bit 31] ]
		// En las posiciones pares los 0s, en las posiciones impares los 1s.
		List<Integer> aux = new ArrayList<>();
		List<Integer> zeros = new ArrayList<>();
		List<Integer> ones = new ArrayList<>();
		for (int i = 0; i < onesAndZeros.size(); i++) {
			List<Integer> current = onesAndZeros.get(i);
			if((i % 2 == 0)){
				zeros.addAll(current);
			}
			else{
				ones.addAll(current);
			}
		}
		return aux;
	}
}
