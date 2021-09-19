package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaptoInt {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4);
        System.out.println(list.stream().mapToInt(v -> v.intValue()).sum());

        int [] arr = {1,2,3,4,5};
        List<Integer> ls = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ls);
        System.out.println(ls.stream().mapToInt(v -> v.intValue()).sum());
        List<Integer> list1= new ArrayList<>();
    }
}
