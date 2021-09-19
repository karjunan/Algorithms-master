package com.google;

import java.util.HashMap;
import java.util.Map;

public class FindPermuationOfStringInAnotherString {

    public static void main(String[] args) {
        String s1 = "krishna";
        String s2 = "rockfellashanyouaretheshnakris";
        System.out.println(checkInclusion(s1,s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) {
            return false;
        }
        return check(s1,s2);
    }

    public static boolean check(String s1, String s2) {

        Map<Character,Integer> s1Map = new HashMap<>();
        Map<Character,Integer> s2Map = new HashMap<>();

        char [] ch1 = s1.toCharArray();
        char [] ch2 = s2.toCharArray();


        int size = ch1.length;

        for(char ch: ch1) {
            s1Map.compute(ch, (key,val) -> val == null ? 1 : val+1);
        }

        for(int i = 0 ; i < size; i++) {
            s2Map.compute(ch2[i], (key,val) -> val == null ? 1 : val+1);
        }

        if(ch1.length == ch2.length) {
            return mapEqual(s1Map,s2Map);
        }


        int start = 0;
        int end = size-1;
        boolean bool = false;
        bool= mapEqual(s1Map,s2Map);
        if(bool) {
            return true;
        }
        while(end < ch2.length) {
            Integer val = s2Map.get(ch2[start]);
            if(val == 1) {
                s2Map.remove(ch2[start]);
            } else {
                s2Map.put(ch2[start], val-1);
            }
            end++;
            start++;
            if(end < ch2.length)
                s2Map.compute(ch2[end],(key,value) -> value == null ? 1: value+1);
            // System.out.println(s1Map);
            // System.out.println(s2Map);
            bool= mapEqual(s1Map,s2Map);
            if(bool) {
                return true;
            }
        }

//         System.out.println("Final validation after looping");
//         System.out.println(s1Map);
//         System.out.println(s2Map);
//         bool = mapEqual(s1Map,s2Map);
        return bool;
    }

    public static boolean mapEqual(Map<Character,Integer> map1,
                            Map<Character,Integer> map2) {

        if(map1.size() != map2.size()) {
            System.out.println("Falied because of size");
            return false;
        }

        for(Map.Entry<Character,Integer> entry: map1.entrySet()) {
            if(!map2.containsKey(entry.getKey())) {
                System.out.println("Falied because of key not present");
                return false;
            }
            Integer val = entry.getValue();
            if(!map2.get(entry.getKey()).equals(val)) {
                return false;
            }
        }
        return true;
    }

}
