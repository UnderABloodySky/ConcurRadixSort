package buffer;

public class Buffer {
    private int[] numbers;
    private int toWrite;
    private int toRead;
    private int capacity;
    private int count;

    public Buffer(int _capacity) {
        numbers = new int[_capacity];
        toWrite = 0;
        toRead = 0;
        count = 0;
        capacity = _capacity;
    }

    public synchronized void write(int _n) {
        while (this.isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        count++;
        numbers[toWrite] = _n;
        this.show(_n, "writing");
        toWrite = this.nextStep(toWrite);
        notify();
    }

    public synchronized int read() {
        while (this.dataNotAvailable()) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        count--;
        int n = numbers[toRead];
        numbers[toRead] = 0;
        this.show(n, "reading");
        toRead = nextStep(toRead);
        notify();
        return n;
    }

    private boolean isFull(){
        return count == capacity;
    }

    private boolean dataNotAvailable(){
        return count == 0;
    }

    private void show(int n, String task) {
        System.out.println("I am " + task + ": " + n);
    }

    private int nextStep(int n) {
        return (n + 1) % capacity;
    }
}

