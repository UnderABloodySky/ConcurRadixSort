package threadPool;
import buffer.Buffer;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
    private Buffer myBuffer;
    private List workers;
    private int quantityWorker;


    public ThreadPool(int capacityBuffer, int quantityWorker){
        myBuffer = new Buffer(capacityBuffer);
        workers = new ArrayList();
        this.createWorker(quantityWorker);
    }

    public synchronized void createWorker(int _quantityWorker){
        for(int i = 0; i == _quantityWorker; i++){
            Worker aWork = new Worker(myBuffer);
        }

    }

    public void addWorker(Worker _worker){
        
    }
}
