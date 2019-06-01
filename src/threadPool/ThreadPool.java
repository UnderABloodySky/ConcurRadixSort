package threadPool;
import buffer.Buffer;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
    private Buffer myBuffer;
    private List workers;

    public ThreadPool(int capacityBuffer, int quantityWorkers){
        myBuffer = new Buffer(capacityBuffer);
        workers = new ArrayList<Worker>(quantityWorkers);
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

        //Tiene que ser syncronied?
        public synchronized void launch(Task aTask){
            myBuffer.write(aTask);
        }

        //Tiene que ser syncronied?
        public synchronized void stop(){
            //Falta
        }
}
