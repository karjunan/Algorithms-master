package com.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AmicableNumber {

    public static void main(String[] args) {

        List<Set<Long>> finalLIst = new ArrayList<>();
        int sum = 0 ;
        for (int i = 1; i <= 10000; i++) {
            List<Long> l1 = amicableNumber(i);
            List<Long> l2 = amicableNumber(l1.stream().mapToInt(v -> v.intValue()).sum());
            HashSet<Long> set = new HashSet<>();
            set.addAll(l1);
            set.addAll(l2);
            if(i == l2.stream().mapToInt(v -> v.intValue()).sum() && l1.stream().mapToInt(v -> v.intValue()).sum() != l2.stream().mapToInt(v ->v.intValue()).sum()) {
                sum = sum + i;
                finalLIst.add(set);
                System.out.println("["+i+"]" + set + ": sum :  " + set.stream().mapToInt(v -> v.intValue()).sum());
            }
        }

        System.out.println("Total amicable " + sum);

    }


    public static List<Long> amicableNumber(long number) {
        List<Long> list = new ArrayList<>();
        for (long i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
