package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSum {
    public static void main (String [] args) {
        int [] combinations = {2,6,3,7};
        int target = 7;
        Arrays.sort(combinations);
        List<List<Integer>> result = new ArrayList<>();
        sum(combinations, target, result, new ArrayList<>(), 0);
        System.out.println(result);
    }

    public static void sum(int [] combinations, int target, List<List<Integer>> result, List<Integer> output, int startIndex) {

        if(target < 0) {
            return;
        }

        if(target == 0) {
            System.out.println(output);
            result.add(new ArrayList<>(output));
            return;
        }

        for(int i = startIndex; i < combinations.length; i++) {
            if(combinations[i] > target) {
                break;
            }
            output.add(combinations[i]);
            sum(combinations, target - combinations[i], result, output, i);
            output.remove(output.size()-1);
        }

    }

    
    
}
