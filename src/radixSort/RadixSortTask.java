package radixSort;

import threadPool.Task;

import java.util.ArrayList;
import java.util.List;

public class RadixSortTask extends Task implements Runnable{
    private int myID;
    private int myFrom;
    private int myTo;
    private int myBit;
    private List<Integer> listToSort;
    private ConvenientBuffer myOnesAndZeros;

    public RadixSortTask(int id, int from, int to, List<Integer> aListToSort, Integer bit, ConvenientBuffer oneAndZeros){
        myID = id;
        myOnesAndZeros = oneAndZeros;
        myFrom = from;
        myTo = to;
        myBit = bit;
        listToSort = aListToSort;
    }

    @Override
    public void run(){
        List<List<Integer>> mySplit = this.split(listToSort, myBit);
        myOnesAndZeros.write(myID, mySplit);
    }

    private List<List<Integer>> split(List<Integer> list , int bit) {
        List<Integer> listToSplit = list.subList(myFrom, myTo);
        List<Integer> zeros = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        List<List<Integer>> result= new ArrayList<>();
        int mask = 1 << bit;
        for (int num  : listToSplit) {
            if (mask == (num & mask) ) {
                ones.add(num);
            }
            else {
                zeros.add(num);
            }
        }
        result.add(0, zeros);
        result.add(1, ones);
        return result;
    }

    //Para testear. Borrar
    public int id(){return myID;}
    public int from(){return myFrom;}
    public int to(){return myTo;}

}
