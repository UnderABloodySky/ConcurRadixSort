package radixSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//Hago esta clasa para probar (ja): Si funciona con un solo thread (el main este podria ser pensado como un solo thread)
//La concurrencia puede salir facil con una barrera, y cada thread solo ordena una partecita de la lista

public class Prueba {
    private static List<Integer> list;
    public static void main(String[] args) {
        list = new ArrayList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < 32; ++i) {
            List<List<Integer>> aux = split(list, i);
            List<Integer> ones =  aux.get(0);
            List<Integer> zeros = aux.get(1);
            result.addAll(ones);
            result.addAll(zeros);
        }

        for (int value : result) {
            System.out.println(value);
        }
    }

    public static List<List<Integer>> split(List<Integer> list, int i){
        List<Integer>  zeros = new ArrayList<Integer>();
        List<Integer> ones = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<>();
        int countOne = 0;
        int countZero = 0;
        int mask = 1 << i ;
        for (int e : list) {
            if ((e & mask) == mask){
                ones.add(e);
                countOne++;
            }
            else{
                zeros.add(e);
                countZero++;
            }
            result.add(ones);
            result.add(zeros);
        }
            return result;
    }
}

