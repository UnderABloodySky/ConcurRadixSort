package radixSort;

import java.util.Arrays;
import java.util.stream.IntStream;

import threadPool.ThreadPool;

public class ConcurRadixSort {
    private ThreadPool myThreadPool;
    public ConcurRadixSort(int bufferSize, int quantityThreads){
        myThreadPool = new ThreadPool(bufferSize,quantityThreads);
    }

    
//    La lista no importa el largo q tenga mientras los numeros se representen
//    en 32 bits
    public int[] radixSort ( int[] listToSort ) {
    	int[]result= {};
    	for (int i = 0; i < 32; ++i) {
    	int [][] aux = this.split(listToSort , i);
    	int[] ones=aux[1];
    	int[] zeros=aux[0];
    	result = IntStream.concat(Arrays.stream(zeros),Arrays.stream(ones)).toArray();//aux[0].concat(aux[1]);
    	}
    	return result ;
    	}
    
    public int[][]	split (int[] listToSplit ,int i) {
    	int[] zeros = {};
    	int[] ones = {};
    	int[][] result= {};
    	int mask = 1 << i;
    	int countDeOnes=0;
    	int countDeZeros=0;
    	for (int num:listToSplit ) {
    	if (num & mask ) {

    		ones[countDeOnes]=num;
    		countDeOnes++;
    		}
    	else {
    		zeros[countDeZeros]=num;
    		countDeZeros++;
    		}
    	}
    	result[1]=ones;
    	result[0]=zeros;
    	return result;
    	}
}
