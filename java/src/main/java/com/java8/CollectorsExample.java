package com.java8;

import java.util.*;

public class CollectorsExample {

    public static void main(String[] args) {

        Map<String,Map<String,List<String>>> country = new HashMap<>();

        Map<String,List<String>> karnataka = new HashMap<>();
        karnataka.putIfAbsent("Bangalore", new ArrayList<>(Arrays.asList("p1", "p2", "p3","p4","p5")));
        karnataka.putIfAbsent("Mysore", new ArrayList(Arrays.asList("p4", "p5", "p6")));
        country.putIfAbsent("Karnataka", karnataka);

        Map<String,List<String>> tamilnadu = new HashMap<>();
        tamilnadu.putIfAbsent("Chennai", new ArrayList(Arrays.asList("p1", "p2", "p3")));
        tamilnadu.putIfAbsent("Coimbatore", new ArrayList(Arrays.asList("p4", "p5", "p6")));
        country.putIfAbsent("tamilnadu", tamilnadu);

         Long val = country.entrySet().stream()
                 .flatMap(v -> v.getValue().entrySet().stream())
                 .flatMap(v -> v.getValue().stream())
                 .count();
        System.out.println(val);

    }


}
