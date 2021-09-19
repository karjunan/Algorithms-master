package com.algorithms.algoExpert;

import java.util.ArrayList;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str = "ZXVVYZW";
        String str1 = "XKYKZPW";
        ArrayList<Character> result = lcs(str,str1);
        System.out.println(result);
    }

    public static ArrayList<Character> lcs(String str, String str1) {
        String [][] arr = new String[str.length()+2][str1.length()+2];

        arr[0][0] = " ";
        arr[0][1] = "'";
        arr[1][0] = "'";

        for(int i = 0 ; i < str.length();i++) {
            int val = i+2;
            arr[val][0] = Character.toString(str.charAt(i));
            arr[val][1] = "'";
        }

        for(int i = 0 ; i < str1.length();i++) {
            arr[0][i+2] = Character.toString(str1.charAt(i));
            arr[1][i] = "'";
        }
        arr[1][arr[0].length-2] ="'";
        arr[1][arr[0].length-1] ="'";


        print(arr);

        for( int i = 2; i < arr.length; i++) {
            for(int j = 2; j < arr[i].length;j++) {
                // System.out.println(arr[i][0] + " - " + arr[0][j]);
                if(!arr[i][0].equalsIgnoreCase(arr[0][j])) {
                    if(arr[i-1][j].length() >= arr[i][j-1].length()) {
                        arr[i][j] = arr[i-1][j];
                    } else {
                        arr[i][j] = arr[i][j-1];
                    }
                } else {
                    arr[i][j] = arr[i][0]+arr[i-1][j-1];
                }
                // print(arr);
            }
        }
        print(arr);
        String s = arr[arr.length-1][arr[0].length-1];
        ArrayList<Character> list = new ArrayList<>();
        int k = s.length() -1 ;
        char element = '\'';
        while(k >= 0 ) {
            if(s.charAt(k) == element){
                k--;
                continue;
            }
            list.add(s.charAt(k));
            k--;
        }
        return list;

    }

    public static void print(String [][] arr) {
        for( int i = 0 ; i < arr.length; i++) {
            for( int j = 0 ; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
