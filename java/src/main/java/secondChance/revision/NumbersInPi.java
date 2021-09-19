package secondChance.revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NumbersInPi {

    public static void main(String[] args) {

        String pi = "314159";
        Set<String> set = new HashSet<>(Arrays.asList("3", "314", "15", "9" , "59","2"));
        int reesult = getMinimumcuts(pi, set, new HashMap<>(), 0 );

        if(reesult == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else  {
            System.out.println(reesult);
        }

    }

    public static int getMinimumcuts(String pi, Set<String> set, HashMap<Integer, Integer> cache, int idx) {


        if(idx == pi.length()) {
            return -1;
        }

        if(cache.containsKey(idx)) {
            return cache.get(idx);
        }

        int count = Integer.MAX_VALUE;
        for(int i = idx; i < pi.length(); i++) {
            String substring = pi.substring(idx, i + 1);
            if(set.contains(substring)) {
                var result = getMinimumcuts(pi, set, cache, i + 1);
                if(result == Integer.MAX_VALUE) {
                    count = Integer.min(count,result);
                    cache.put(idx, count);
                } else {
                    count = Integer.min(count, result+1);
                    cache.put(idx, count);
                }
            }
        }
        cache.put(idx, count);
        return count;
    }
}
