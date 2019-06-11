package radixSort;
import java.util.ArrayList;
import java.util.List;

public class MainIndex {
    public static void main(String[] args) {

        List<Integer> prueba = new ArrayList<>();
        for (Integer i = 0; i < 11; i++) {
            prueba.add(new Integer(i));
        }

        int x = prueba.size();
        int n = 120;
        int count = 0;
        int from = 0;
        int to = 0;
        List<List<Integer>> aux = new ArrayList<>();
        while (0 < n) {
            int y = x / n;
            if ((x % n) != 0) {
                y++;
            }
            x -= y;
            n--;
            to += y;
            aux.add(prueba.subList(from, to));
            from = to;
        }
        System.out.println(aux.toString());
    }
}
