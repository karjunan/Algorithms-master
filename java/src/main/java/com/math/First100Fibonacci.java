package com.math;

import java.math.BigDecimal;

public class First100Fibonacci {
    public static void main(String[] args) {

        find100thFibonacci(1000);
//        char ch = Character.;
//        System.out.println(ch);

    }

    public static void find100thFibonacci(int pos) {
        BigDecimal f1 = new BigDecimal(1);
        BigDecimal f2 = new BigDecimal(1);
        int counter = 2;
        while (true) {
            BigDecimal temp = f2;
            f1 = f1.add(f2);
            f2 = f1;
            f1 = temp;
            if (f1.toString().length() >= pos) {
                break;
            }
            counter++;
        }
        System.out.println(counter + " ::" + f1 + " ::: " + f2);
    }
}
