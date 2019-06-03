package radixSort;

import java.util.Arrays;
import java.util.stream.IntStream;

//Hago esta clasa para probar (ja): Si funciona con un solo thread (el main este podria ser pensado como un solo thread)
//La concurrencia puede salir facil con una barrera, y cada thread solo ordena una partecita de la lista

public class Prueba {
    private static int[] list;
    public static void main(String[] args) {
        list = new int[4];
        list[0] = 4;
        list[1] = 3;
        list[2] = 2;
        list[3] = 1;
        int[] result = new int[8];
        for (int i = 0; i < 32; ++i) {
            int[][] aux = split(list, i);
            int[] ones = aux[0];
            int[] zeros = aux[1];
            result = IntStream.concat(Arrays.stream(ones), Arrays.stream(zeros)).toArray();
        }
        for (int value : result) {
            System.out.println(value);
        }
    }

    public static int[][] split(int[] list, int i){
        int[]  zeros = new int[] {};
        int[] ones = new int[] {};
        int[][] result = new int[2] [];
        int countOne = 0;
        int countZero = 0;
        int mask = 1 << i ;
        for (int e : list) {
            if (0 != (list[e] & mask)){
                ones[countOne] = e;
                countOne++;
            }
            else{
                zeros[countZero] = e;
                countZero++;
            }
            result[0] = ones;
            result[1] = zeros;
        }
            return result;
    }
}

