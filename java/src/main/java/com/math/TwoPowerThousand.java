package com.math;

import java.math.BigDecimal;

public class TwoPowerThousand {

    public static void main(String[] args) {

        findTwoPowerThousand(15);
    }

    public static void findTwoPowerThousand(int times) {
        BigDecimal bigDecimal = new BigDecimal(2);
        bigDecimal = bigDecimal.pow(1000);


        System.out.println(bigDecimal.toString());

        int s = bigDecimal.toString().chars().mapToObj(v -> String.valueOf((char)v)).mapToInt(v -> Integer.parseInt(v)).sum();

        System.out.println("sum is ::" +s );
//        System.out.println(bigDecimal.toString().chars().mapToLong(v -> Integer.valueOf((char)v)).sum());
        //
//        String str = String.valueOf(v);
//        System.out.println("str length :; " + str.length());
//
//        long sum = str.chars().mapToObj(var -> String.valueOf((char)var)).mapToInt(x -> Integer.parseInt(x))
//                .sum();
//
////        System.out.println(v);
//        System.out.println(sum);

    }
}
