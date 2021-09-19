package com.geeksForgeeks;

public class TrappingRainWater {

    public static void main(String[] args) {

        int [] arr = new int [] {5,0, 6, 2, 3};
        System.out.println("Final Result " + trapRainWater(arr));
    }

    public static int trapRainWater(int [] arr) {

        int result = 0;
        for(int i = 1 ; i < arr.length - 1; i++) {


            int lMax = arr[i];


            for( int k = 0 ; k < i; k++) {
                lMax = Math.max(lMax,arr[k]);
            }

            int rMax = arr[i];

            for( int k = i+1 ; k < arr.length-1; k++) {
                rMax = Math.max(rMax,arr[k]);
            }

            int min = (Math.min(lMax,rMax) - arr[i]);
            result = min + result;
            System.out.println("Result is " + result);
        }

        return result;
    }
}
