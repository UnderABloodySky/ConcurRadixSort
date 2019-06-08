package radixSort;

import threadPool.AddMonitor;
import threadPool.ConvenientBarrier;
import threadPool.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class RadixSortTask extends Task {
	
    private int myIdTask;
	private int myFrom;
    private int myTo;
    private int myBit;
    private List<Integer> myResult;
    private Map<Integer,List<List<Integer>>> myOnesAndZeros;
    private ConvenientBarrier myConvenientBarrier;
    private AddMonitor myAddMonitor;

    public RadixSortTask(int idTask,int from, int to, List<Integer> result, int bit,Map<Integer,List<List<Integer>>> oneAndZeros,ConvenientBarrier convenientBarrier,AddMonitor addMonitor){
        myIdTask=idTask;
    	myOnesAndZeros = oneAndZeros;
        myFrom = from;
        myTo = to;
        myBit = bit;
        myResult = result;
        myConvenientBarrier=convenientBarrier;
        myAddMonitor=addMonitor;
    }

    @Override
    public void run(){
        List<List<Integer>> mySplit = this.split(myResult, myBit);
        myAddMonitor.add(myOnesAndZeros,myIdTask, mySplit);
        myConvenientBarrier.notifyPass();
    }

    private List<List<Integer>> split(List<Integer> list ,int bit) {
        List<Integer> listToSplit = list.subList(myFrom, myTo);
        List<Integer> zeros = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        List<List<Integer>> result= new ArrayList<>();
        int mask = 1 << bit;
        for (int num : listToSplit) {
            if (mask == (num & mask) ) {
                ones.add(num);
            }
            else {
                zeros.add(num);
            }
        }
        result.add(zeros);
        result.add(ones);
        return result;
    }

}
