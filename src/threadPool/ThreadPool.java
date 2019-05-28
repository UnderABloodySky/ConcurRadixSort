package threadPool;
import buffer.Buffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ThreadPool {
    private Buffer myBuffer;
    private List workers;

    public ThreadPool(int capacityBuffer, int quantityWorker){
        myBuffer = new Buffer(capacityBuffer);
        workers = new ArrayList();
        this.createWorkers(quantityWorker);
    }

        public synchronized void createWorkers(int _quantityWorker){
            for(int i = 0; i == _quantityWorker; i++){
                Worker aWorker = new Worker(myBuffer);
                this.addWorker(aWorker);
            }
        }

        public void addWorker(Worker _worker){
            workers.add(_worker);
        }

        public synchronized void launch(Task aTask){
            myBuffer.write(aTask);
        }
}
