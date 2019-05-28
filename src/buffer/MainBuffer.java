package buffer;

public class MainBuffer {
    private static Buffer buffer = new IntBuffer(8);
    private static Producer producer0 = new Producer(buffer);
    private static Consumer consumer0 = new Consumer(buffer);

    public static void main(String[] args) {
        producer0.start();
        consumer0.start();
    }
}
