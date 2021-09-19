package com.afterlongpractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetSum {

    public static void main(String[] args) {

        int [] val = new int[] {2,5,6,3,9,7};
        Arrays.sort(val);
        System.out.println(Arrays.toString(val));
        int targetSum = 11;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        findSubSets(result,val,0,output,targetSum);
        System.out.println(result);
    }


    public static void findSubSets(List<List<Integer>> result, int [] arr, int idx,
                                   List<Integer> output,int runningSum) {
        //System.out.println(runningSum);
        if(idx == arr.length || runningSum < 0) {
            return;
        }
        if(runningSum == 0) {
            System.out.println(" found a set of values "+ output);
            result.add(new ArrayList<>(output));
            return;
        }


        output.add(arr[idx]);
        findSubSets(result,arr,idx+1,output,runningSum-arr[idx]);
        output.remove(output.size()-1);
        findSubSets(result,arr,idx+1,output,runningSum);






    }

}
