package com.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramOnTwoStrings {


    static String s = "cbaebabacd";
    static String p = "abc";

    // static String s ="abab";
    // static String p ="ab";


    public static void main(String[] args) {

        System.out.println("Result -> " + anagrams(s, p));

    }

    // cba bae aeb

    public static List<Integer> anagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }

        int i = 0;
        int j = p.length();
        char[] ch = p.toCharArray();
        Arrays.sort(ch);
        String modified = new String(ch);
        List<Integer> list = new ArrayList<>();
        while (i <= (s.length() - p.length())) {
            int k = i + j;

            String m = s.substring(i, k);
            char[] ch1 = m.toCharArray();
            Arrays.sort(ch1);
            String modified1 = new String(ch1);
            if (modified.equals(modified1)) {
                list.add(i);
            }
            System.out.println("String m  = " + m);
            i++;
        }

        return list;
    }
}
