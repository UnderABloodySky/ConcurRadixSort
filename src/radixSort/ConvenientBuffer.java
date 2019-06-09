package radixSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvenientBuffer {
        private Map<Integer, List<List<Integer>>> slots;
        private int writers;
        private int myQuantity;

        public ConvenientBuffer(int quantity) {
            writers = 0;
            slots = new HashMap<>();
            myQuantity = quantity;
        }

        public synchronized void write(Integer aID,List<List<Integer>> onesOrZeros) {
            System.out.println("TAREA WRITE: " + aID);
            writers++;
            slots.put(0, onesOrZeros);
            notifyAll();
        }

        public synchronized List<Integer> aplanate(){
            while(writers < myQuantity){
              try{
                  wait();
                }
                catch(InterruptedException e){
                    System.out.println("EXCEPCION");
                }
            }

            List<Integer> zeros = new ArrayList<>();
            List<Integer> ones = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            for (int id = 0; id < myQuantity; id++) {
                List<List<Integer>> current = slots.get(id);
                zeros.addAll(current.get(0));
                ones.addAll(current.get(1));
            }
            result.addAll(zeros);
            result.addAll(ones);
            return result;
        }
}


