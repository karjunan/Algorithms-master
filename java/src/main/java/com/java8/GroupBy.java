package com.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("krishna");
        list.add("kumar");
        list.add("kumaran");
        list.add("Ram");
        Map<Boolean,List<String>> countOfNames = list.stream()
                                    .collect(Collectors.partitioningBy(v -> v.contains("k")));

        countOfNames.entrySet().stream()
                .forEach(System.out::println);

        Map<Integer,List<String>> nameMap = list.stream()
//                                    .filter(v -> v.contains("k"))
                                    .collect(
                                            Collectors.collectingAndThen(
                                                    Collectors.groupingBy(String::length),
                                                    Collections::unmodifiableMap));
        nameMap.put(1,new ArrayList<>());
        nameMap.entrySet().stream()
                .forEach(System.out::println);

    }
}
