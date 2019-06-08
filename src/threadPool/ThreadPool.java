package threadPool;
import buffer.Buffer;
import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
    private Buffer myBuffer;
    private List<Worker> workers;
    private int quantityWorkers;

    public ThreadPool(int capacityBuffer, int _quantityWorkers){
        myBuffer = new Buffer(capacityBuffer);
        workers = new ArrayList<Worker>(_quantityWorkers);
        quantityWorkers = _quantityWorkers;
        this.createWorkers(quantityWorkers);
    }

        public synchronized void createWorkers(int _quantityWorker){
            for(int i = 0; i == _quantityWorker; i++){
                Worker aWorker = new Worker(myBuffer);
                this.addWorker(aWorker);
                aWorker.start();
            }
        }

        private void addWorker(Worker _worker){
            workers.add(_worker);
        }

        public void launch(Task aTask){
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

