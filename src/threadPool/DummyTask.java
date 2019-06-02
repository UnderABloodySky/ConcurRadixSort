package threadPool;

public class DummyTask extends Task implements Runnable{

    @Override
    public void run(){
        System.out.println("I am doing a dummy task!");
    }

}
