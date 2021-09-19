package com.google;

public class MininumNumberOfCoinChange {

    public static void main(String[] args) {

//        int [] arr = new int[] {1,5,6,9};
//        int value = 10;
//        int [] arr = new int[] {25,10,5};
//        int value = 30;

        int [] arr = new int[] {9,6,5,1};
        int value = 11;

        int result = minimumNumberOfWaysToMakeChange(arr,value);
        System.out.println("Minimum coins required are => " +  result);
    }

    public static int minimumNumberOfWaysToMakeChange(int [] arr, int value) {

        int [] solutionArray = new int[value + 1];

        for( int i = 0; i < solutionArray.length; i++) {
            solutionArray[i] = Integer.MAX_VALUE-1;
        }

        int arrPosition = 0;
        solutionArray[0] = 0;
        while(arrPosition < arr.length) {
            int i = 1;
            while( i < solutionArray.length ) {
                if(i >= arr[arrPosition]) {
                    int val = i - arr[arrPosition];
                    solutionArray[i] = Integer.min(solutionArray[i], 1+solutionArray[val]);
                }
                i++;
            }
            print(solutionArray);
            arrPosition++;
        }

        System.out.println(" ======================== ");
        print(solutionArray);
        return solutionArray[solutionArray.length-1];
    }

    public static void print(int [] arr) {
        for(int i = 0 ; i < arr.length; i++ ) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println("\n");
    }


}
