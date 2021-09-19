package com.algorithms.groupon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
//        String str = "cbbd";
//        String str = "cbbd";
        String str = "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";
        longestPalindromicSubstring(str);
    }

    public static void longestPalindromicSubstring(String str) {

        int mid = 0;
//        Set <String> set = new HashSet<>();
        Comparator<String> comparator = Comparator.comparing(String::length).reversed();
        PriorityQueue<String> set = new PriorityQueue<String>(comparator);
        set.add(String.valueOf(str.charAt(0)));
        while(mid < str.length()) {
            String odd = isPalindrome(str, mid, mid,set);
            String even = isPalindrome(str, mid, mid + 1,set);
            mid++;
        }

        System.out.println(set);
    }

    public static String isPalindrome(String str, int mid, int offset,PriorityQueue<String> set) {
        int left = mid;
        int right = offset;

       // System.out.println("Mid and offset = " + mid +  "=== " + offset + "  " + right + "  " +  str );
        String result = "";
        while(left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            }
            result = str.substring(left,right+1);
           // System.out.println("left and right " + left + " ======  " + right + " = " + result);
            set.add(result);
          //  System.out.println(set);
            left--;
            right++;
        }
        return result;
    }
}
