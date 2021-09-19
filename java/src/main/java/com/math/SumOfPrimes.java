package com.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SumOfPrimes {

    public static void main(String[] args) {
//2000000
        System.out.println(findSumOfPrimes(2000000).stream().mapToLong(v -> v.longValue()).sum());
    }


    public static List<Long> findSumOfPrimes(long limit) {
        boolean bool = false;
        List<Long> primeNumbers = new LinkedList<>();
        List<Long> list = new ArrayList<>();
//        list.add(2l);
        primeNumbers.add(2l);
        primeNumbers.add(3l);
        for(int i = 4 ; i < limit; i++) {
            long sqrt = (long)Math.sqrt(i);
            if( ((LinkedList<Long>) primeNumbers).getLast() >= sqrt ) {
                for(int val = 0; val < primeNumbers.size(); val++){
                    if( i % primeNumbers.get(val) == 0) {
                        bool = true;
                        break;
                    }
                    if(primeNumbers.get(val) > sqrt ) {
                        bool = false;
                        break;
                    }
                }
                if(!bool) {
                    primeNumbers.add(new Long(i));
                }

                bool = false;
            }
//            System.out.println(primeNumbers);
        }


        return primeNumbers;
    }
}
