package secondChance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumSwapsToSortArray {

    public static void main(String[] args) {
        int[] array = new int[] {5,4,3,2,1};

        List<Integer[]> pairs = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            Integer[] in = new Integer[2];
            in[0] = array[i];
            in[1] = i;
            pairs.add(in);
        }
//        print(pairs);
        Collections.sort(pairs, (a,b) -> a[0].compareTo(b[0]));
//        print(pairs);

        int cycles = findCycle(pairs,array);
        System.out.println(" Is the total swaps found =>>> " + cycles);
    }

    private static int findCycle(List<Integer[]> pairs, int[] array) {

        boolean[] visited = new boolean[array.length];
        int totalCycle = 0;
        for(int i = 0; i < array.length; i++) {
            if(visited[i] || pairs.get(i)[1] == i) {
                continue;
            }

            int cycle = 0;
            int current = i;
            while(!visited[current]) {
                visited[current] = true;
                current = pairs.get(current)[1];
                cycle += 1;
            }
            totalCycle += (cycle -1);
        }

        return totalCycle;

    }

    public static void print(List<Integer[]> pairs) {
        pairs.forEach(v -> System.out.println(Arrays.toString(v)));
        System.out.println(" ------------------- ");
    }
}
