package com.algorithms.arrayproblems;

import java.util.Arrays;

public class FindMedianOfTwoArrays {

//    static int [] arr = {1,12,15,26,38};
    static int [] arr = {1,12,15};
    static int [] arr1 = {2,13,17,30,45};
//    static int [] arr1 = {2,13,17};
    public static void main(String [] args) {
//        arr1 = new int[0];
        int result = merge(arr,arr1);

        System.out.println(" Result is : " + result);
    }

    public static int merge(int [] arr, int [] arr1) {

        int [] result = new int[arr.length + arr1.length];

        if(arr.length == 0 && arr1.length == 0) {
            return 0;
        } else if(arr.length == 0 ) {
            return findMedian(arr1);
        } else if (arr1.length == 0) {
            return findMedian(arr);
        } else {
            int i = 0;
            int j = 0;
            int counter = 0;
            while(counter < result.length && i < arr.length && j < arr1.length)       {
                if( arr[i] < arr1[j]) {
                    result[counter] = arr[i];
                    i++;
                } else {
                    result[counter] = arr1[j];
                    j++;
                }
                counter++;

            }
            while(i < arr.length) {
                result[counter] = arr[i++];
                counter++;
            }

            while(j < arr1.length) {
                //System.out.println("Counter>>" + counter + " : j >> " + j );
                result[counter] = arr1[j];
                j++;
                counter++;
            }
            System.out.println(Arrays.toString(result));

            return findMedian(result);
        }


    }

    public static int findMedian(int [] res) {

        if(res.length == 0) {
            return 0;
        }

        int mid = res.length/2;
        if(res.length % 2 == 1 ) {
            return res[mid];
        } else {
            System.out.println(res[mid-1] + " ::: " + res[mid] );
            return (res[mid-1] + res[mid])/2;
        }


    }


}
