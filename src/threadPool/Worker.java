package threadPool;

import buffer.Buffer;

public class Worker extends Thread {
    private Buffer aBuffer;

    public Worker(Buffer _buffer){
        aBuffer = _buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Task aTask = (Task) aBuffer.read();
                aTask.run();
            }
            catch (PoisonException e){
                //e.printStackTrace();
                break;
            }
        }
    }
}

