package threadPool;

public class MainThreadPool {

    public static void main(String[] args){
        ThreadPool myThreadPool = new ThreadPool(100, 1);
        for (int i= 0; i < 100; i++) {
            myThreadPool.launch(new DummyTask());
        }
        myThreadPool.stop();
    }
}
