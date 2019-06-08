package threadPool;

public class MainThreadPool {

    public static void main(String[] args){
        ThreadPool myThreadPool = new ThreadPool(4, 25);
        for (int i= 0; i < 100; i++) {
            myThreadPool.launch(new DummyTask());
        }
        //}
        //myThreadPool.stop();
    }
}
