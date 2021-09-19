package com.string;

import java.util.Arrays;

public class DIStringMatch {

    static String str = "IDID";
    // static String str = "III";
    // static String str = "DDI";

    public static void main(String [] args) {
        System.out.println(Arrays.toString(diStringMatch(str)));
    }
    public static int[] diStringMatch(String str) {
        int N = str.length();
        int [] arr = new int[N+1];
        int i = 0;
        int j = N;
        int k = 0;
        while( k  < N) {
            if(str.charAt(k) == 'I' ) {
                arr[k] = i;
                i++;
            } else {
                arr[k] = j;
                j--;
            }
            k++;
        }

        arr[k] = i;
        return arr;
    }
}
