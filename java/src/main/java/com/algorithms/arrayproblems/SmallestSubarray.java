package com.algorithms.arrayproblems;

import java.util.ArrayList;
import java.util.List;

public class SmallestSubarray {

    public static void main(String[] args) throws Exception {
        // Integer [] arr  = {1, 4, 9, 6, 0, 19};

          //10 {1,9} {1,}

        Integer [] arr  = {1, 10, 5, 2, 7};
        int val = 11;
        int min = findMinSubArray(arr,val);
        System.out.println(min);
    }


    public static int findMinSubArray(Integer [] arr, int val) {

        int index1 = 0;
        int index2 = index1;
        int current = val+1;

        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();

        if(arr[index1] > val ) {
            return 1;
        }


        while(index1 <= index2 && index2 < arr.length-1 && index1 < arr.length-1) {
            System.out.println("current" + current);
            current = current - arr[index2];
            if( current >= 0  ) {
                list.add(arr[index2]);
                index2++;
            } else  {
                list.add(arr[index2]);
                finalList.add(list);
                System.out.println("List values : " + list);
                list = new ArrayList<>();
                index1++;
                index2 = index1;
                current = val;
            }

        }

        return finalList.stream().mapToInt(v->v.size()).min().getAsInt();

    }
}
