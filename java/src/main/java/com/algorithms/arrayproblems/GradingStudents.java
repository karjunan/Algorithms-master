package com.algorithms.arrayproblems;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class GradingStudents {

    static String [][] str =  { { "Barry", "-66" },
            { "Barry", "-65" },
            { "Alfred", "-122"} };

    public static void main(String[] args) {

        Map<String,List<Integer>>  map = new HashMap<>();
        Map<String,Integer>  streamMap = new HashMap<>();


        for(int i = 0 ; i < str.length; i++) {
            List<Integer> list = null;
            for(int j = 0; j < str[i].length; j++) {
                System.out.print(str[i][j] + " \t" );
                if(j == 0 ) {
                    List<Integer> ls = map.get(str[i][j]);
                    if(null == ls || ls.isEmpty()) {
                        list = new ArrayList<>();
                        list.add(Integer.parseInt(str[i][j+1]));
                    } else {
                        ls.add(Integer.parseInt(str[i][j+1]));
                        map.put(str[i][j],ls);
                    }
                    if(null != list && list.size() <=1) {
                        map.put(str[i][j],list);
                    }

                }
            }
            System.out.println("");
        }

        Map<String,OptionalDouble> map1 = new HashMap<>();
         map.entrySet().stream()
                     .forEach(v -> {
                         map1.put(v.getKey(),v.getValue().stream().mapToInt(l -> l.intValue()).average());
                     });

         OptionalDouble d = map1.entrySet().stream()
                 .mapToDouble(v -> v.getValue().getAsDouble())
                 .max();
        System.out.println(d);

    }
}
