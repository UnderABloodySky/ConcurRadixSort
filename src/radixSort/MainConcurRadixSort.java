package radixSort;

import java.util.ArrayList;
import java.util.List;

public class MainConcurRadixSort {
    private static ConcurRadixSort radix;
    private static int quantityThreads;
    private static List<Integer> toOrder;

    public static void main(String[] args){
       toOrder = generateListToOrder();
       System.out.println("");
       System.out.println(" - Original list: ");
       System.out.println("Size original list: " + toOrder.size());
       System.out.println("");
       System.out.println(toOrder.toString());
       System.out.println("");
       System.out.println("");

       radix = new ConcurRadixSort(100000, 5100);
       List<Integer> sortedList = radix.radixSort(toOrder);
       System.out.println("___________________________________________________________________________________________");

       System.out.println("");
       System.out.println("");
       System.out.println(" - Ordened list: ");
       System.out.println("Size sorted list: " + sortedList.size());
       System.out.println("");
       System.out.println(sortedList.toString());
    }

    private static List<Integer> generateListToOrder() {
        List<Integer> aux = new ArrayList();

        for (int i = 0; i < 100000000; ++i) {
           int elem = (int) (Math.random() * 100000);
           aux.add(elem);
        }
        return aux;
    }
}