package com.java8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringToStream {
    public static void main(String[] args) {
        String str = "HelloKrishna";
        String [] s = str.split("");
        //int [] arr = {1,2,3};
        List<String> ls = new ArrayList<>();
        ls = Arrays.asList(s);
        System.out.println(ls);
        List<String> ls1 = new ArrayList<>();
        ls1.add("ab");
        ls1.add("cd");
        List<List<String>> list = new ArrayList<>();
        list.add(ls);
        list.add(ls1);
        int size = list.stream().flatMap(v -> v.stream()).collect(Collectors.toList()).size();
        System.out.println("Size is " + size);

    }
}
