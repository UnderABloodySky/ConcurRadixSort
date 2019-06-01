package threadPool;

public class PoisonPill extends Task implements Runnable{

    @Override
    public void run(){
        throw new PoisonException("You shall not pass!");
    }
}
