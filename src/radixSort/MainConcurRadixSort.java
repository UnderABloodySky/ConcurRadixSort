package radixSort;

public class MainConcurRadixSort {
    private static ConcurRadixSort radix;
    private static int quantityThreads;
    private static int[] toOrder;

    public static void main(String[] args){
        quantityThreads = 2;
        generateListToOrder();
        radix = new ConcurRadixSort(8, quantityThreads);
        int[] ordened = radix.radixSort(toOrder);
    }

    //Esto es para cuando ya este funcionando lo que pide el enunciado del TP
    private static synchronized void generateListToOrder() {

        for (int i = 0; i < 10000; i++) {
            toOrder[i] = (int) (Math.random() * 10000);
        }
    }

}
