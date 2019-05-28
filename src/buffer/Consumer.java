package buffer;

public class Consumer extends Thread{
        private Buffer myBuffer;

        public Consumer(Buffer _buffer){
            myBuffer = _buffer;
        }

        public void consume(){
            while(true){
                int elem = (int)myBuffer.read();
                System.out.println("Consuming: "  + elem);
            }
        }

        @Override
        public void run(){
            this.consume();
        }
}
