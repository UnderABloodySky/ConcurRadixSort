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
       System.out.println("");
       System.out.println(toOrder.toString());
       System.out.println("");
       System.out.println("");

       radix = new ConcurRadixSort(100, 2);
       List<Integer> ordenedList = radix.radixSort(toOrder);
       System.out.println("___________________________________________________________________________________________");

       System.out.println("");
       System.out.println("");
       System.out.println(" - Ordened list: ");
       System.out.println("");
       System.out.println(ordenedList.toString());
    }

    private static List<Integer> generateListToOrder() {
        List<Integer> aux = new ArrayList();

        for (int i = 0; i < 8; ++i) {
           int elem = (int) (Math.random() * 10000);
           aux.add(elem);
        }
        return aux;
    }
}
/*
*      for(Integer elem : listToSort){
            System.out.println(elem);
        }


* */