package com.algorithms.arrayproblems;

import java.util.Arrays;
import java.util.Random;

public class GenerateRandom {
    public static void main(String[] args) {

        int [] arr = new int[] {1,2,3,4,5,6,7,8,9,0};
        int [] counter = new int[1];
        int val = 4;

        int [] result = generateRandom(arr,counter,val);
        System.out.println(Arrays.toString(result));
        result = generateRandom(arr,counter,val);
        System.out.println(Arrays.toString(result));
        result = generateRandom(arr,counter,val);
        System.out.println(Arrays.toString(result));
        result = generateRandom(arr,counter,val);
        System.out.println(Arrays.toString(result));

        System.out.println(" Now see the next set of value -------------------. How cool it is ");


            result = generateRandom(arr,val);
            System.out.println(Arrays.toString(result));
            result = generateRandom(arr,val);
            System.out.println(Arrays.toString(result));
            result = generateRandom(arr,val);
            System.out.println(Arrays.toString(result));
            result = generateRandom(arr,val);
            System.out.println(Arrays.toString(result));

    }


    public static int [] generateRandom(int [] arr, int m) {
        int result[] = new int[m];
        for(int i = 0 ; i < m; i++) {
             result[i] = arr[i];
        }
        Random random = new Random();
        for(int i = m; i < arr.length; i++) {
            int pos = random.nextInt(i);
            if(pos < m) {
                result[pos] = arr[i];
            }
        }
       return result;
    }

    public static int[] generateRandom(int [] arr, int[] counter, int val)  {

        int [] result = new int[val];

        if(val > arr.length) {
            return new int[]{};
        }
        for(int i = 0 ; i < result.length ; i++) {
            if(counter[0] == arr.length ) {
                counter[0] = 0;
            }
            result[i] = arr[counter[0]];
            counter[0]++;
        }

        return result;
    }
}
