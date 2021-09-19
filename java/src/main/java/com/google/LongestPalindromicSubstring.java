package com.google;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {


    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        System.out.println(isPalindromicSubstring(str));
        Map<String, Boolean> map = new HashMap<>();
        longestPalindromicSubstring(str,0,0,map);
    }


    public static void longestPalindromicSubstring(String str, int i , int j,
                                                   Map<String,Boolean> map) {
        if(i >= str.length() || j >= str.length()) {
            return;
        }

        char [] ch = str.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for(int k = i ; k <= j ; k++) {
            buffer.append(ch[k]);
        }

        if (isPalindromicSubstring(buffer.toString()) && buffer.toString().length() > 2) {
                System.out.println("Palindromic substring " + buffer.toString());
        }

        map.put(buffer.toString(),true);
//        System.out.println(map);

        longestPalindromicSubstring(str, i, j + 1, map);

        char [] ch1 = str.toCharArray();
        StringBuffer buffer1 = new StringBuffer();
        for(int k = i+1 ; k < j+1 ; k++) {
            buffer1.append(ch1[k]);
        }
        if(!map.containsKey(buffer1.toString())) {
            longestPalindromicSubstring(str, i + 1, i + 1, map);
        }

    }

    private static boolean isPalindromicSubstring(String substring) {

        int i = 0;
        int j = substring.length()-1;

        while(i < j) {
            if(substring.charAt(i) != substring.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
