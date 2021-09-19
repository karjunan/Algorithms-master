package com.algorithms.arrayproblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramSequence {


    static String [] arr = {"cat", "dog", "tac", "god", "act"};

    public static void main(String [] args) {

        printAnagramTogether(arr);
    }

    public static void printAnagramTogether(String [] arr) {

        Map<String,LinkedList<String>> map = new HashMap<>();
        for( int i = 0 ; i < arr.length; i++) {
            char [] ch = arr[i].toCharArray();
            Arrays.sort(ch);

            if(map.containsKey(new String(ch))) {
                LinkedList<String> str = map.get(new String(ch));
                str.add(arr[i]);
            } else {
                LinkedList<String> list = new LinkedList<>();
                list.add(arr[i]);
                map.put(new String(ch),list);
            }
        }

        System.out.println(map);

        List<String> list = map.entrySet().stream().flatMap(v -> v.getValue().stream()).collect(Collectors .toList());

        System.out.println("Final Output >> " + list);

    }

}
