package com.math;

import java.util.ArrayList;
import java.util.List;

public class SmallestMultiple {

    public static void main(String[] args) {

        System.out.println(smallestMultiple(20));
    }

    public static List<Integer> smallestMultiple(int upto) {
        List<Integer> list = new ArrayList<>();
        int k = 1;
        int i = 1;
        boolean bool = false;
        while(true) {
            if( k % i == 0) {
                i++;
                if(i == upto) {
                    list.add(k);
                    break;
                }
                continue;
            } else {
                k++;
                i = 1;
            }

//            System.out.println(list);


        }
        return list;
    }
}
