package com.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {

    public static void main(String[] args) {
        String s =  "cbaebabacd";
        String p =  "baba";
        List<Integer> list = findAnagrams(s,p);
        System.out.println(list);
    }


    public static List<Integer> findAnagrams(String s, String p) {

        if(p.length() > s.length()) {
            return new ArrayList<>();
        }

        List<Integer> finalList = new ArrayList<>();
        Map<Character,Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for(char ch: p.toCharArray()) {
            pMap.compute(ch, (k,v) -> v == null ? 1: v + 1);
        }
        System.out.println(pMap);

        int i = 0;
        for(; i < p.length(); i++) {
            char ch = s.charAt(i);
            if(pMap.containsKey(ch)) {
                sMap.compute(ch, (k,v) -> v == null ? 1: v + 1);
            }
        }
        if(sMap.size() == pMap.size()) {
            for(Map.Entry<Character,Integer> entry: pMap.entrySet()) {
                if(!sMap.containsKey(entry.getKey()) || sMap.get(entry.getKey()) != entry.getValue()) {
                   break;
                }
                finalList.add(i - p.length());
            }
        }

        for(; i < s.length(); i++) {

            sMap.remove(i-p.length());
//            if(s.charAt())
        }
        return new ArrayList<>();
    }
}
