package com.algorithms.algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplets {

    static int [] arr = {12,3,1,2,-6,5,-8,6};
    static int val = 0;


    public static void main(String[] args) {

        triplets(arr,val);

    }



    public static void triplets(int [] arr, int val) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        for( int i = 0 ; i < arr.length; i++) {
            int temp = arr[i];
            int j = (i+1);
            int k = arr.length - 1;
            int mid = val - temp;
            while(j < k) {
                List<Integer> ls = new ArrayList<>();
                while(k >= 0 && (arr[j] + arr[k]) > mid) {
                    k--;
                }

                while(k >= 0 && (arr[j] + arr[k]) < mid) {
                    j++;
                }

                if(j < k && (arr[j] + arr[k]) == mid) {
                    ls.add(arr[i]);
                    ls.add(arr[j]);
                    ls.add(arr[k]);
                    j++;
                    list.add(ls);
                }

            }


        }
        System.out.println(list);
    }


    public static List<Integer[]> threeNumberSum(int[] array,int targetSum)
    {

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int k = 0;

        List<Integer[]> list = new ArrayList<>();
        while( k < array.length ) {
            int i = k+1;
            int j = array.length - 1;
            while(i < j) {
                Integer[] in = new Integer[3];
                int result = array[k] + array[i] + array[j];
                if(result == targetSum) {
                    in[0] = array[k];
                    in[1] = array[i];
                    in[2] = array[j];
                    list.add(in);
                    // print(list);
                    i++;
                } else if(result > targetSum) {
                    j--;
                } else if(result < targetSum) {
                    i++;
                }
            }
            k++;
        }
        return list;

    }

}
