package secondChance;

import java.util.Arrays;

public class MaxSubSetSumNoAdjacent {



    public static void main(String[] args) {
        //int [] array  = {75, 105, 120, 75, 90, 135, 190};
        int [] array = {10, 5, 20, 25, 15, 5, 5, 15, 3, 15, 5, 5, 15};
        System.out.println(Arrays.toString(array));
        if(array.length == 0) {
            System.out.println(" No elements present");
        }
        if(array.length == 1) {
            System.out.println(array);
        }
        int [] max = new int[1];

        //int maxValue = helper(array,0,Integer.MIN_VALUE);
        int [] cache = new int[array.length];
        Arrays.fill(cache, -1);
        int maxValue1 = max(array, 0, 0, cache);
      //  System.out.println(" The max is => "+ maxValue1 + " === " + maxValue);
        System.out.println(" The max is => "+ maxValue1);
    }

    public static int max(int [] array, int idx, int current, int[] cache) {
        System.out.println(Arrays.toString(cache));
        if(idx >= array.length) {
            return current;
        }

        if(cache[idx] != -1) {
            System.out.println("  Returning from cache ==> " + cache[idx] + " === " + idx + " ===  " + Arrays.toString(cache));
            return cache[idx];
        }
        int currentMax = 0;

        for(int i = idx; i < array.length; i++) {
            currentMax = Integer.max(currentMax, max(array, i+2, current + array[i], cache));
            cache[idx] = Integer.max(cache[idx], currentMax);
        }

        cache[idx] = currentMax;
        return currentMax;
    }

    public static int helper(int[] array, int i, int prev) {
        System.out.println( i + " :: " + prev );
        if(i == array.length) {
            return 0;
        }

        int exclude = helper(array,i+1,prev);
        int include = 0;
        if(prev + 1 != i) {
            include = helper(array,i+1,i) + array[i];

        }
        return Integer.max(include,exclude);
    }
}
