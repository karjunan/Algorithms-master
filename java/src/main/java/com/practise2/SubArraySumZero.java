package com.practise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubArraySumZero {

    public static void main(String[] args) {

        int [] arr = new int [] {7,6,5,4,3,2,1,-4,-2,-2,-5,-2,2,3};
        naiveApproach(arr);
        System.out.println("\n\n");
        slidingWindow(arr);
    }

    public static void slidingWindow(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer[]> list = new ArrayList<>();
        int currentSum = 0;
        for(int i = 0 ; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            if(!map.containsKey(currentSum)) {
                map.put(currentSum,i);
            }  else {
                Integer[] in = new Integer[2];
                in[0] = map.get(currentSum) + 1;
                in[1] = i;
                list.add(in);

            }
        }
        list.forEach(v -> System.out.println(Arrays.toString(v)));
    }

    public static int naiveApproach(int[] arr) {

        List<Integer[]> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            int currentSum = arr[i];
            for(int j = i+1; j < arr.length; j++) {
                currentSum = currentSum + arr[j];
                if(currentSum == 0) {
                    Integer[] t = new Integer[2];
                    t[0] = i;
                    t[1] = j;
                    list.add(t);
                }
            }
        }
        list.forEach(v -> System.out.println(Arrays.toString(v)));
        return 0;

    }

    /*

     */


}
