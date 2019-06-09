package radixSort;

public class Counter {
    private Integer counter;

    public Counter(){
        counter = 0;
    }

    public synchronized Integer value(){
        Integer aux = counter;
        counter++;
        return aux;
    }
}
