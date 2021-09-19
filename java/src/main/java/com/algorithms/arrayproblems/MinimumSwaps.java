package com.algorithms.arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumSwaps {


    public static void main(String[] args) {


        int [] arr = {4, 5, 2, 1, 5};

        List<Integer> list;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for( int i = 0 ; i < arr.length; i++) {
            list = new ArrayList<>();
            list.add(i);
            map.put(arr[i],list);
        }

        int result = minSwaps(arr, map);
        System.out.println(" Final Result >>" + result);

    }

    public static int minSwaps(int [] arr,Map<Integer,List<Integer>> map ) {

        int [] arr1 = Arrays.copyOf(arr,arr.length);

        Arrays.sort(arr1);


        for( int i = 0 ; i < arr1.length; i++) {
            List<Integer> ls = map.get(arr1[i]);
            ls.add(i);
            map.put(arr1[i], ls);
        }

        System.out.println("Original >> " + Arrays.toString(arr)+"\n" );
        System.out.println("New >>" + Arrays.toString(arr1)+"\n" );
        System.out.println(map);

        boolean [] bool = new boolean[arr.length];


        int result = 0;
        for( int i = 0 ; i < arr.length; i++) {
            int val = arr[i];
            int current = val;
            int j = i;
            int moves = 0;

            while( !bool[j] ) {
                bool[j] = true;
                j = map.get(current).get(1);
                current = arr[j];
                moves++;
                System.out.println(">> " + Arrays.toString(bool));
            }
            if(moves > 0) {
                result = result + (moves - 1);
            }

            System.out.println(" >> "  +result);
        }


        return result;
    }


}
