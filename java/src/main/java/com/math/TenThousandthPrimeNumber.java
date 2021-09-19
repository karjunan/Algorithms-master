package com.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TenThousandthPrimeNumber {

    public static void main(String[] args) {
        findPrimeLocation(10001);
    }


    public static void findPrimeLocation(long val) {

        List<Long> list = new LinkedList<>();
        boolean bool = false;
        for (long i = 2; i < Long.MAX_VALUE; i++) {
            for (long j = 3; j < i; j++) {
                if (i % j == 0) {
                    bool = true;
                    break;
                }

            }

            if(!bool && list.size() <= val) {
                list.add(i);
            }

            if(list.size() > val) {
                break;
            }
            bool = false;
        }
        System.out.println(list);

        System.out.println(((LinkedList<Long>) list).getLast());
    }

}
