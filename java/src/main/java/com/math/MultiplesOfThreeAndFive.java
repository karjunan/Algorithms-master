package com.math;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class MultiplesOfThreeAndFive {

    public static void main(String[] args) {

        int three = 3;
        int five  = 5;
        List<Integer> list = new ArrayList();
        for(int i = 0 ; i< 1000; i++) {
            if(i % three == 0 ||(i % five == 0) ) {
                list.add(i);
            }

        }

//        for(int i: list) {
//            System.out.println(i);
//        }

        OptionalInt val = list.stream().mapToInt(v -> v)
                .reduce((v,s) -> v + s );

        System.out.println(val.getAsInt());

    }
}
