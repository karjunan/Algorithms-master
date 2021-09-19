package com.algorithms.arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindSumPair {
    static Integer [] arr =  {11, 15, 6, 8, 9, 10,8};
    public static void main(String [] args) {
//        Integer [] arr =  {11, 15, 6, 8, 9, 10,16};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
        List<Integer> out = new ArrayList<Integer>();


        findPairs(list,out,16);
        pairSum(16,arr);
    }

    public static void pairSum(int sum, Integer [] arr) {
        Arrays.sort(arr);
        print(arr);
        int i = 0;
        int j = arr.length-1;

        while( i <= j ) {
            if(arr[i]+arr[j] == sum && i != j) {
                System.out.println("("+arr[i]+","+arr[j]+") => " + i + ": "+ j);
                i++;
                j--;
            } else if((arr[i] + arr[j])  < sum) {
                i++;
            } else if((arr[i] + arr[j]) > sum ) {
                j--;
            }

        }
    }

    public static void print(Integer [] arr) {
        Stream.of(arr).mapToInt(v -> v.intValue()).forEach(v -> System.out.print(" " + v));
        System.out.println("\n");
    }


    public static void findPairs( List<Integer> list, List<Integer> out,int var) {

        if(list.isEmpty()) {
            // System.out.println(out + ">>" + out.size());
            if(out.size() == 2 &&
                    out.stream().mapToInt(v -> v.intValue()).sum() == var) {
                System.out.println("Pair Found :: >>" + out);
            }
        } else {

            //choose
            int val = list.remove(0);

            //explore
            findPairs(list,out,var);
            out.add(val);

            findPairs(list,out,var);
            //unchoose
            int val1 = out.remove(out.size()-1);
            list.add(val1);
        }

    }

}
