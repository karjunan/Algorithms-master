package com.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Anagram {

    @FunctionalInterface
    interface AnagramSolution {
        Set<Set<String>> group(List<String> list);

    }


    public static void main(String[] args) {

        List<String> list = Arrays.asList("cat","dog","act","god","tac","abcd");

        AnagramSolution a = words -> {

            Map<String,Set<String>> map =  words.stream().collect(Collectors.groupingBy(v -> {
                char [] c = v.toCharArray();
                Arrays.sort(c);
                return new String(c);
            },Collectors.toSet()));

            System.out.println(map);

            Set<Set<String>> s = new HashSet<>();

            for(Map.Entry<String,Set<String>> en : map.entrySet()) {
                s.add(en.getValue());
            }

            return s;
        };

        System.out.println(a.group(list));
    }

}
