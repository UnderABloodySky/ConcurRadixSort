package radixSort;

import java.util.ArrayList;
import java.util.List;

public class MainConcurRadixSort {
    private static ConcurRadixSort radix;
    private static int quantityThreads;
    private static List<Integer> toOrder;

    public static void main(String[] args){
       toOrder = generateListToOrder();
       quantityThreads = 1;
       radix = new ConcurRadixSort(100, quantityThreads);
       radix.radixSort(toOrder);
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
