package com.google;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        int N = (int)Math.pow(2, list.size());
        List<List<String>> finalList = new ArrayList<>();
        System.out.println("Value of N => " + N);
        for (int j = 0; j < N; j++) {
            List<String> subset = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {

                if((j & (1 << i)) != 0 ) {
                    System.out.println("Value of i " + i);
                    subset.add(list.get(i));
                }
//                System.out.println(subset);
//                System.out.println(Integer.toBinaryString(i));
            }
            finalList.add(subset);
        }

        System.out.println("Final  List => " + finalList);
    }
}
