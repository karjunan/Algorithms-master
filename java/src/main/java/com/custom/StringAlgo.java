package com.custom;

import java.util.HashMap;
import java.util.Map;

public class StringAlgo {
    public static void main(String[] args) {
        String [] str = new String []{"a","b","c","d","a","d"};
        Map<String,Integer> map = new HashMap<>();
        for(String s : str) {
            map.compute(s, (k,v) -> v == null ? 1 : v+1);
        }
        System.out.println(map);
    }
}
