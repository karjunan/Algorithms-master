package com.algorithms.algoExpert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllPalindromicSubStrings {
    static String str = "geeksforgeeks";

    public static void main(String args [] ) {

        System.out.println("Is this working really wow 1 2 3");
        List<String> list = findAllPalindrominSubstring(str);
        System.out.println(list + " ->  " + list.size());

    }

    public static List<String> findAllPalindrominSubstring(String str) {

        List<String> list = new ArrayList<>();
        for( char ch :str.toCharArray()) {
            list.add(Character.toString(ch));
        }

        int k = 0;

        String finalString = "";
        while( k < str.length() - 1 ) {
            int j = k+1;
            int i = k-1;
            Set<String> even = findPalindrome(str,i,j);
            Set<String> odd = findPalindrome(str,k,j);
            list.addAll(odd);
            list.addAll(even);
            k++;
        }

        return list;
    }

    public static Set<String> findPalindrome(String str, int i , int j) {
        Set<String> set = new HashSet<>();
        while(i >=0 && j < str.length()) {
            if(str.charAt(i) == str.charAt(j)) {
                set.add(str.substring(i,j+1));
                i--;
                j++;
            } else {
                break;
            }
        }
        return set;
    }
}
