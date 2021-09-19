package com.algorithms.arrayproblems;

public class MinSwapsToBringElementsToOneSide {


    public static void main(String[] args) {


        int [] arr =  {5, 2, 1, 3, 4};
        int k = 5;

        int count = minSwaps(arr,k);
        System.out.println(" Final count >> " + count);
    }


    public static int minSwaps(int [] arr, int k) {

        int i = 0 ;
        int j = arr.length - 1;
        int counter = 1;
        while( i <= j ) {

            while(arr[i] < k ) {
                i++;
                continue;
            }

            if(arr[j] < k && arr[i] > k) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                counter++;
            }
            j--;

        }
        return counter;
    }

}
