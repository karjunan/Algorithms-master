package com.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsGrouping {



    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("Krishna");
        list.add("Swathi");
        list.add("Mithra");
        list.add("Minerva");
        list.add("A");
        list.add("AB");

        List<String> str = list.stream()
                .filter(v -> v.contains("hna"))
                .collect(Collectors.toList());

        Map<Integer, List<String>> map = list.stream()
                .collect(Collectors.groupingBy(v -> v.length())
                );

        print(map);
//        map.entrySet().stream().forEach(v -> {
//            System.out.println(v.getKey() + ": " +v.getValue());
//         } );
//        }

        Map<Integer, Long> listMap = list.stream()
                .collect(Collectors.groupingBy(v -> v.length(), Collectors.counting())
                );

        print(listMap);

        }


        static <V extends Map> void print(V v ) {
            System.out.println("----------Entry---------------");
            v.entrySet().stream()
                    .forEach(k -> System.out.println(k));
            System.out.println("----------Exit---------------");

        }


}
