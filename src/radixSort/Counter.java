package radixSort;

public class Counter {
    private Integer counter;

    public Counter(){
        counter = 0;
    }

    public synchronized void increment(){
        counter++;
    }

    public synchronized Integer value(){return counter;}
}
