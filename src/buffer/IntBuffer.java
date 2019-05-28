package buffer;

public class IntBuffer extends Buffer  {
    private int toWrite;
    private int toRead;
    private int capacity;
    private int count;

    public IntBuffer(int _capacity) {
        super(_capacity);
    }

    public synchronized void write(int _n) {
        super.write(_n);
        this.show(_n, "writing");
    }

    @Override
    public synchronized Object read() {
        Object result = super.read();
        this.show((int)result, "reading");
        return (int)result;
    }

    private void show(int n, String task) {
        System.out.println("I am " + task + ": " + n);
    }

}
