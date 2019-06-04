package radixSort;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
//import java.util.stream.IntStream;

import threadPool.ThreadPool;

public class ConcurRadixSort {
    private ThreadPool myThreadPool;
//    private static int[] list;
    public ConcurRadixSort(int bufferSize, int quantityThreads){
        myThreadPool = new ThreadPool(bufferSize,quantityThreads);
    }

    
//    La lista no importa el largo q tenga mientras los numeros se representen
//    en 32 bits
    public List<Integer> radixSort ( List<Integer> listToSort ) {
    	List<Integer> result= listToSort;
    	for (int i = 0; i < 32; ++i) {
//    	int [][] aux = this.split(listToSort , i);cambio desde aca
    	result=this.split(result, i);	
//    	int[] ones=aux[1];
//    	int[] zeros=aux[0];
//    	result = IntStream.concat(Arrays.stream(zeros),Arrays.stream(ones)).toArray();//aux[0].concat(aux[1]);
    	}
    	return result ;
    	}
    
    public List<Integer>	split (List<Integer> listToSplit ,int i) {
    	List<Integer> zeros = new ArrayList<Integer>();
    	List<Integer> ones = new ArrayList<Integer>();
    	List<Integer> result= new ArrayList<Integer>();
    	int mask = 1 << i;
//    	int countDeOnes=0;
//    	int countDeZeros=0;
    	for (int num:listToSplit ) {
    	if (mask == (num & mask) ) {

    		ones.add(num);
//    		countDeOnes++;
    		}
    	else {
    		zeros.add(num);
//    		countDeZeros++;
    		}
    	}
    	
    	result.addAll( zeros);
    	result.addAll( ones);
    	return result;
    	}
//    
//    public static void main(String[] args) {
//        list = new int[4];
//        list[0] = 4;
//        list[1] = 3;
//        list[2] = 2;
//        list[3] = 1;
//        
//        int[][] result= split(list,0);
////        for (int[] value : result) {
////            System.out.println(value);
////        }
//        System.out.println(result);
//    }
}
