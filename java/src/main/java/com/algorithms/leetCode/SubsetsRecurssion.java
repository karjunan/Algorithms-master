package com.algorithms.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SubsetsRecurssion {


    public static void main(String [] args) {
        int [] arr = {3,2,1};
        Arrays.sort(arr);
        partition(arr);
    }

    public static void partition(int [] arr) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> cur = Arrays.stream(arr).mapToObj(i -> Integer.valueOf(i)).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        partitionHelper(cur,list,ls,0);

        System.out.println(ls);

    }

    public static void partitionHelper(ArrayList<Integer> input, ArrayList<Integer> output,
                                       ArrayList<ArrayList<Integer>>result,int val) {

        System.out.println(">>>>>>>>>>." + output);
        for( int i = val; i < input.size();i++) {
            output.add(input.get(i));
            System.out.println(output);
            result.add(new ArrayList<Integer>(output));
            partitionHelper(input,output,result,i+1);
            output.remove(output.size()-1);
        }

    }
}
