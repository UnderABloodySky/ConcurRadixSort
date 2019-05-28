package buffer;

public class Producer extends Thread {
    private Buffer myBuffer;

    public Producer(Buffer _buffer){
        myBuffer = _buffer;
    }

        public void produce() {
            int init = 0;
            while (true) {
                myBuffer.write(init);
                System.out.println("Producing: " + init);
                init++;
            }
        }

        @Override
        public void run(){
            this.produce();
        }
}
