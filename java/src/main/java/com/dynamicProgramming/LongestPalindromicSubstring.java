package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {


        static String str = "abab";
        public static void main(String[] args) {

            String val = longestPalindrome("abab");
            System.out.println("Result is >> " + val);
            longestPalindromeDP(str);
        }

        public static String longestPalindromeDP(String s) {
            int length = s.length();

            char [][] arr = new char[s.length() + 1][s.length() + 1];

            int val = 0;
            for( int i = 1 ; i <= length; i++) {
                arr[i][0] = s.charAt(val);
                val++;
            }

            val = 0;
            for( int i = 1 ; i <= length; i++) {
                arr[0][i] = s.charAt(val);
                val++;
            }
            int j = 1;
            for( int i = 1 ; i <= length ;i++) {
                arr[i][j] = '1';
                j++;
            }


            for(int i = 1; i < length; i++) {
                j = i+1;
                if(arr[i][0] == arr[0][j]) {
                     arr[i][j] = '1';
                } else{
                    arr[i][j] = '0';
                }
            }

            for(  int i = 3; i <= length; i++) {
                for( int  k = 1; k <= length; k++) {


                }
            }

            print(arr);
            return  null;

        }

        public static  void print(char [][] ch) {
            for( int i = 0 ; i < ch.length; i++) {
                for(int j = 0 ; j < ch[i].length; j++) {
                    System.out.print(ch[i][j] + "   ");
                }
                System.out.println("\n");
            }
        }

        public static String longestPalindrome(String s) {

            if(s.length() == 1) {
                return s;
            }
            int i = 0;
            int j = 1;
            List<String> list = new ArrayList<>();
            while( j < s.length()) {

                while(i <= j && j <= s.length()) {
                    String val = s.substring(i,j);
                    boolean bool = isPalindrome(val);
                    // System.out.println("Result >> " + val);
                    if(bool ) {
                        if(list.isEmpty())
                            list.add(val);
                        else if(val.length() > list.get(list.size()-1).length()) {
                            list.add(val);
                        }
                    }
                    j++;
                }
                i++;
                j = i+1;

            }
            if(list.isEmpty()) {
                return "";
            }

            return list.get(list.size()-1);
        }

        private static boolean isPalindrome(String str) {
            char [] ch = str.toCharArray();
            int j = ch.length - 1;
            for( int i = 0 ; i < ch.length/2; i++,j--) {

                if(ch[i] != ch[j]) {
                    return false;
                }

            }
            return true;
        }
}

