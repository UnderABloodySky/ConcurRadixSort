package threadPool;

public class MainThreadPool {
    private static ThreadPool myThreadPool;

    public static void main(String[] args){
        myThreadPool = new ThreadPool(8, 8 );

        for (int i= 0; i == 100; i++){
            myThreadPool.launch(new DummyTask());
        }
        myThreadPool.stop();
    }
}
