package com.algorithms.arrayproblems;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Anagrams {

    public static void main(String[] args) {

        String str = "listen";
        String str1 = "silentt";
        System.out.println(anagram(str,str1));
    }

    public static boolean anagram(String str, String str1) {

        Map<Character, Integer> map = new ConcurrentHashMap<>();
        Map<Character, Integer> map1 = new ConcurrentHashMap<>();


        str.chars().mapToObj(v -> (char) v).forEach(v -> map.compute(v, (k, s) -> s == null ? 1 : s + 1));


        str1.chars().mapToObj(v -> (char) v).forEach(v -> map1.compute(v, (k, s) -> s == null ? 1 : s + 1));


        for (Map.Entry<Character, Integer> m : map.entrySet()) {

            map1.computeIfPresent(m.getKey(), (k, s) -> (s == m.getValue()) ? map1.remove(k) : --s);
        }

        System.out.println(map1);

        if(map1.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
