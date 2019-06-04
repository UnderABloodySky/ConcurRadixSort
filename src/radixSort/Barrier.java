package radixSort;

public class Barrier {
    private int waiting;
    private int limit;
    public Barrier(int _n){
        waiting = 0;
        limit = _n;
    }

    public synchronized void waiting(){
        while(waiting < limit){
            waiting++;
            try{
                wait();
            }
            catch (InterruptedException e) {

            }
            notifyAll();
        }
    }
}
