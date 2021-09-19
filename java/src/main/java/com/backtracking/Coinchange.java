package com.backtracking;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coinchange {

    public static void main(String [] args) {
        int [] arr = {1,2,3};
        int n = 4;
        int [] arr1 = new int[n+1];

        for( int i = 0 ; i < arr1.length; i++) {
            arr1[i] = 0;
        }

        List<Integer> list = Arrays.stream(arr)
                .mapToObj(v-> Integer.valueOf(v)).collect(Collectors.toList());


        int result = coinChange(n,list,0,arr1);
        System.out.println("Final Result >> " +result);

    }

    public static int coinChange(int n, List<Integer> list, int i, int [] arr) {
        System.out.println("n >>" + n);

        if (n < 0) {
            return 0;
        }

        if ( n == 0 ) {
            return 1;
        }

        if (i == list.size() && n > 0){
            return 0;
        }

        if(arr[i] != 0) {
            return arr[i];
        }

        int result = coinChange(n - list.get(i) , list,i,arr) + coinChange(n,list,++i,arr);
        arr[n] = result;
        System.out.println(Arrays.toString(arr));
        return result;
    }

}
