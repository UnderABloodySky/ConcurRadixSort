package threadPool;

import buffer.Buffer;

public class Worker extends Thread {
    private Buffer aBuffer;

    public Worker(Buffer _buffer){
            aBuffer = _buffer;
    }

    public void toWork(){
        Task aTask = (Task)aBuffer.read();
        aTask.run();
    }
}

