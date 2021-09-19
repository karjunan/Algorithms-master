package com.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class GroupingBy {

   static int [] arr = new int[10];

    public static void main(String[] args) {

        List<String>  list = List.of("kri","kumar","lo","a","aa","kk","f");

        Map<String,String>  mapData = new HashMap<>();
        mapData.put("kri","sku1");
        mapData.put("kumar","sku2");
        mapData.put("aa","sku3");

        List<String> lss = list.stream()
                .collect( Collector.of(() -> new ArrayList<>(), (k,v) -> {
                        String str = mapData.get(v);
                        k.add(str);
                },
                (k,v) -> {
                    k.addAll(v);
                    return v;
                } ));

        String str = "abcc";
        String str1 = "dec";

       Map<Character,Long> ch = str.chars().mapToObj(v -> Character.valueOf((char)v))
                .collect(Collectors.groupingBy(v -> v,counting()));

        Map<Character,Long> ch1 = str1.chars().mapToObj(v -> Character.valueOf((char)v))
                .collect(Collectors.groupingBy(v -> v,counting()));

        System.out.println(ch);
        System.out.println(ch1);

        ch = ch.entrySet().stream()
                .filter(v -> ch1.containsKey(v.getKey()))
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));

        ch.entrySet().forEach(v -> {
            long val = Math.abs(ch1.get(v.getKey()) - v.getValue());
            v.setValue(val);
        });

        Optional<Long> sum = Optional.empty();
        if(sum.isPresent())
            System.out.println(sum.get());
        else {
            System.out.println(0);
        }
//        System.out.println(sum.get());

        Set<Character> set = str.chars().mapToObj(v -> Character.valueOf((char)v))
                .collect(Collectors.toSet());


        Map<Character,Integer> uMap = new HashMap<>();
        uMap.compute('a' , (k,v) -> v==null ? 1 : v + 1);
        uMap.compute('a' , (k,v) -> v==null ? 1 : v + 1);
        uMap.compute('a' , (k,v) -> v==null ? 1 : v + 1);
        uMap.compute('a' , (k,v) -> v==null ? 1 : v + 1);

        System.out.println("Mappng Function : " + uMap);


        pringList(lss);

        Map <Boolean,List<String>> map = list.stream()
                                            .collect(Collectors.partitioningBy(v -> v.startsWith("k")));


        print(map);
        Map <Boolean,Long> map1 = list.stream()
                                        .collect(Collectors.partitioningBy( v -> v.startsWith("k"),
                                                Collectors.counting()));
        print(map1);

        Map<Boolean, List<String>> glist = list.stream().collect(groupingBy(v -> v.startsWith("k")));

        print(glist);

        Set<String> fMap = list.stream().collect(Collectors.filtering(v -> v.startsWith("l"), Collectors.toSet()));

        pringList(fMap);

        Map<Integer,List<String>> gMap = list.stream().collect(toMap(k -> k.length(), v -> {
            List<String > ls = new ArrayList<>();
            ls.add(v);
            return ls;
                },
                (m,n) ->{
                    m.addAll(n);
                    return m;
                }));

        print(gMap);

//        Stream.generate(() -> generate(arr)).forEach(System.out::println);


    }

    public  static void pringList(Collection<?> list ) {
        list.forEach(System.out::println);
    }

    public static void print(Map<?,?> map) {
        map.entrySet().forEach(v -> System.out.println(v.getKey() + ":: " + v.getValue() ));
    }


    public static int [] generate(int [] arr) {
        for(int i = 0 ;i< 10; i++) {
            arr[i] = i;
        }
        return arr;
    }



}
