package threadPool;

public class DummyTask implements Runnable{

    @Override
    public void run(){
        System.out.println("I am doing a dummy task!");
    }

}
