package threadPool;

public class ConvenientBarrier {
    private int pass;
    private int limit;

    public ConvenientBarrier(int _n){
        pass = 0;
        limit = _n;
    }

    public synchronized void waiting(){
        while(pass < limit){
            try{
                wait();
            }
            catch (InterruptedException e) {

            }
            notify();
            pass = 0;
        }
    }
    public synchronized void notifyPass(){
        pass++;
    }
}
