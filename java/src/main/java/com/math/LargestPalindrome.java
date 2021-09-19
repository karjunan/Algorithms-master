package com.math;

import java.util.ArrayList;
import java.util.List;

public class LargestPalindrome {

    public static void main(String[] args) {

        System.out.println(largestPalindrome());
    }

    public static long largestPalindrome() {
        List<Long> list = new ArrayList<>();
        long val = 0;
        for (int i = 999; i > 100; i--) {
            for (int j = 999; j > 100; j--) {
                if (isPalindrome(String.valueOf(i * j))) {
//                    System.out.println((i * j));
//                    System.out.println("["+i+"]["+j+"]");
                    val = i*j;
                    list.add(val);
                }
            }
        }
        return list.stream().mapToInt(v -> v.intValue()).max().getAsInt();
    }

    public static boolean isPalindrome(String str) {
        int val = str.length() - 1;
        boolean bool = false;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(val) == str.charAt(i)) {
                bool = true;
                val--;
            } else {
                bool = false;
                break;
            }
        }
        return bool;
    }
}
