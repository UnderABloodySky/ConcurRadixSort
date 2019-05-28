package buffer;

public class MainBuffer {
    private static Buffer buffer;
    private static  Producer producer0;
    private  static Consumer consumer0;

    public static void main(String[] args) {
        buffer = new Buffer(8);
        producer0 = new Producer(buffer);
        consumer0 = new Consumer(buffer);

        producer0.start();
        consumer0.start();
    }
}
