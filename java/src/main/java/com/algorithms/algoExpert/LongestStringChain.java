package com.algorithms.algoExpert;

import java.util.*;

public class LongestStringChain {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("kris");
        ls.add("a");
        ls.add("before");
        Collections.sort(ls,(s1,s2) -> s1.length() < s2.length() ? -1: 1);
        System.out.println(ls);
        String s= "abdefg";
        System.out.println(s.substring(0,0));
        System.out.println(s.substring(1,s.length()));
        System.out.println(s.substring(0,2)+s.substring(3,s.length()));
        Map<String,String> map = new HashMap<>();

    }
}
