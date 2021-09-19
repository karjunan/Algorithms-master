package com.java8;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MapExample {

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("k",1);
        map.put("k",1);
        map.entrySet().stream()
                .forEach(v -> System.out.println(v.getKey()));

        StringBuilder str = new StringBuilder("krishna");
        System.out.println(str.reverse());
        String rev = str.reverse().toString();

        Stream<Character> charStream = rev.chars().mapToObj(v -> (char)v);

//        charStream.forEach(v -> System.out.println(v));

        Spliterator<Character> characterSpliterator = charStream.spliterator();
        Spliterator<Long[]> arraySpliterator =  new LongSpliteratorExample(characterSpliterator);

        StreamSupport.stream(arraySpliterator,false)
                .map(v -> v[1])
                .forEach(v -> System.out.println(v));

        int [] arr = {1,2,3};
       StringBuilder builder = new StringBuilder("123");
        System.out.println(builder.reverse());
//                .forEach(v -> System.out.println("["+v[0]+"]["+v[1]+"]"));



//        arraySpliterator.forEachRemaining(v -> System.out.println("["+v[0]+"]["+v[1]+"]"));

}

}
