package threadPool;
import buffer.Buffer;

public class ThreadPool {
    private Buffer myBuffer;
    private int quantityWorkers;

    public ThreadPool(int capacityBuffer, int _quantityWorkers){
        myBuffer = new Buffer(capacityBuffer);
        quantityWorkers = _quantityWorkers;
        this.createWorkers(quantityWorkers);
    }

        private synchronized void createWorkers(int _quantityWorker){
            for(int i = 0; i < _quantityWorker; i++){
                Worker aWorker = new Worker(myBuffer);
                aWorker.start();
            }
        }

        public synchronized void launch(Runnable aTask){
            myBuffer.write(aTask);
        }

        public synchronized void stop(){
            int count = 0;
            while(count <= quantityWorkers){
                myBuffer.write(new PoisonPill());
                count ++;
            }
        }
}

