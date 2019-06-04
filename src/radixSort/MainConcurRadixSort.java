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
        aux.add(6);
        aux.add(9);
        aux.add(3);
        aux.add(8);
        aux.add(21);
        aux.add(99);
        aux.add(0);
        aux.add(1);
        aux.add(2);
       // for (int i = 0; i < 10000; ++i) {
       //     int elem = (int) (Math.random() * 10000);
       //     aux.add(new Integer(elem));
       // }
        return aux;
    }
}
