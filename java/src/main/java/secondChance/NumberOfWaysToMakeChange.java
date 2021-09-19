package secondChance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfWaysToMakeChange {

    public static void main(String[] args) {
        int total = 6;
        int [] denoms = {1,2,3};
        Map<Integer, Integer> cache = new HashMap<>();
        int result = ways(denoms, total, 0,cache);
        System.out.println(result);
    }

    public static int ways(int [] denoms, int total, int idx, Map<Integer, Integer> cache ) {
        System.out.println(total +  " ===  " + cache);
        if( total < 0) {
            return 0;
        }

        if(total == 0) {
            return 1;
        }

        if(cache.containsKey(total)) {
            System.out.println(" hitting the cache now  =>> " + total + " === " + cache.get(total));
            return cache.get(total);
        }

        int change = 0;

        for(int i = idx; i < denoms.length; i++) {
            change += ways(denoms, total - denoms[i], i, cache);

        }

        cache.put(total, change);

        return change;
    }

}
