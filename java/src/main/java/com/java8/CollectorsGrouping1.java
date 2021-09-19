package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsGrouping1 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("Krishna");
        list.add("Swathi");
        list.add("Mithra");
        list.add("Minerva");
        list.add("Kumar");


        Map<String,List<String>> map = list.stream().collect(Collectors.groupingBy(v-> v.substring(0,1)));
        Map<Integer,List<String>> map1 = list.stream().collect(Collectors.groupingBy(v -> v.length()));
        Map<Character,List<String>> map2 = list.stream().collect(Collectors.groupingBy(v -> v.charAt(0)));
        Map<String,Long> map3= list.stream().collect(Collectors.groupingBy(v -> v.substring(0,1),Collectors.counting()));


        System.out.println(map);
        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);

    }
}
