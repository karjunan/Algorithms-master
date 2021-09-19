package com.algorithms.arrayproblems;

import java.util.LinkedList;

public class ReversePairs {

    public static void main(String [] args) {

        int [] arr = {4, 6, 8, 9, 1, 5, 10, 11};

        int val = reversePairs(arr);
        System.out.println("Total Pairs" + val);

    }


    public static int reversePairs(int [] arr) {

        int i = 0 ;
        int j = 1;

        while(arr[i++] < arr[j++]) {
            continue;
        }

        i = 0;
        int mid = j - 1;
        System.out.println( "J position >> " + j);
        LinkedList<LinkedList<Integer>> finalList = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();


        while( i < mid ) {
            j = mid;
            while(j < arr.length -1 && arr[i] > arr[j])  {
                list = new LinkedList<>();
                list.add(arr[i]);
                list.add(arr[j]);
                j++;
                finalList.add(list);
            }
            System.out.println(finalList);
            i++;
        }
        return finalList.size();
    }
}
