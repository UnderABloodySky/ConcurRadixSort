package radixSort;

import java.util.ArrayList;
import java.util.List;

public class MainConcurRadixSort {
    private static ConcurRadixSort radix;
    private static int quantityThreads;
    private static List<Integer> toOrder;

    public static void main(String[] args){
       toOrder = generateListToOrder();
       System.out.println("Original List: ");
       System.out.println("");
       for(Integer elem : toOrder){
           System.out.println(elem);
       }
       System.out.println("");
       System.out.println("_________________________________________________________________________");
       System.out.println("");
       quantityThreads = 3;
       radix = new ConcurRadixSort(10, quantityThreads);
       radix.radixSort(toOrder);
       System.out.println("Ordened List: ");
       for(Integer elem : toOrder){
            System.out.println(elem);
        }
    }

    private static List<Integer> generateListToOrder() {
        List<Integer> aux = new ArrayList();
        for (int i = 0; i < 10000; ++i) {
            int elem = (int) (Math.random() * 10000);
            aux.add(elem);
        }
        return aux;
    }
}
