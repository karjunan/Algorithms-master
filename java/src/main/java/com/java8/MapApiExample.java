package com.java8;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapApiExample {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        for(Map.Entry<String,Integer> entry: map.entrySet()) {

        }
       String current = "riskkkna";
       String matcher = "(.*)k(.*)";

        System.out.println(current.matches(matcher));
        char ch = 'b';
        String str;
        System.out.println((int)'b'-96);
        Character c = Character.valueOf((char)97);
//        System.out.println(c);
        map.put("k",1);
        map.compute("k",(k,v) ->{
            if(null == v ) {
                return 0;
            } else
                v++;
                return v;
        } );
        map.entrySet().forEach(v -> System.out.println(v.getKey()+ " - "+ v.getValue()));
    }
}
