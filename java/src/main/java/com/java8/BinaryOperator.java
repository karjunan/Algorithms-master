package com.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class BinaryOperator {

    Object object = new Object();
    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5,6,8,9,10,12};

        Integer finalVal = StreamSupport.stream(IntStream.of(arr).spliterator(),false)
                .filter(v -> v % 2 == 0 )
                .reduce(0,(total,currentValue) -> {
                    System.out.println("Current Value :: " + currentValue);
                    System.out.println(" Total  : " + total);
                    return currentValue + total;
                });

        //2+4+6+8 = 20
        System.out.println("Result : " + finalVal);
        List<Integer> list = new ArrayList<>();
        IntStream.range(0,10000)
                .forEach(v -> list.add(v, v));

        Runnable rn = () -> {
            IntStream.range(0,10000)
                    .forEach(v -> {int data = list.get(v);
                                    list.add(data);
                                    });
        };
        Thread th = new Thread(rn);
        th.start();

//        System.out.println(list);

            list.removeIf(v -> v == 21);

        System.out.println(list);


        System.out.println(list);


    }
}
