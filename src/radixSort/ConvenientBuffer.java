package radixSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvenientBuffer {
        private Map<Integer, Map<Integer, List<Integer>>> slots;
        private int writers;
        private int myQuantity;

        public ConvenientBuffer(int quantity) {
            writers = 0;
            slots = new HashMap();
            myQuantity = quantity;
        }

        public synchronized void write(Integer aID, Integer aBit, List<List<Integer>> onesOrZeros) {
            //NO hago wait() xq no se llena. Ademas, nunca deberia darse el caso de que un thread (n+1) corra en paralelo con un thread n
            writers++;
            List<Integer> zeros = onesOrZeros.get(0);
            List<Integer> ones = onesOrZeros.get(1);
            slots.get(aID).put(aBit, zeros);
            slots.get(aID).put(aBit, zeros);
        }

        public synchronized List<Integer> aplanate(int bit){
            while(writers < myQuantity){
                try{
                    wait();
                }
                catch(InterruptedException e){
                }
            }
            List<Integer> zeros = new ArrayList<>();
            List<Integer> ones = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            for (int id = 0; id < myQuantity; id++) {
                Map<Integer, List<Integer>> current = slots.get(id);

                zeros.addAll(current.get(0));
                ones.addAll(current.get(1));
            }
            result.addAll(zeros);
            result.addAll(ones);
            return result;
        }
}


