package com.math;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PrimeFactors {

    public static void main(String[] args) {

        System.out.println(primeFactors(121l));
        List<Long> list = new ArrayList<>();
        System.out.println(primeFactorRecursion(121l, 2l, list));
    }


    public static List<Long> primeFactorRecursion(Long val, Long factor, List<Long> list) {
        if(factor > val) {
            return list;
        }
        if (val % factor == 0) {
            val = (val / factor);
            list.add(factor);
        } else {
            factor++;
        }
        primeFactorRecursion(val,factor,list);
        return list;
    }

    public static Collection<Long> primeFactors(Long val) {
        List<Long> list = new ArrayList<>();
        for(long i = 1 ; i <= val; i++) {
            if(val % i == 0) {
//                val = (val /i);
                list.add(i);
            }
        }

        return list;
    }
}
