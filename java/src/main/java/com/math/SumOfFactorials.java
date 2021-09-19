package com.math;

import java.math.BigDecimal;

public class SumOfFactorials {

    public static void main(String[] args) {
        BigDecimal b = fact(new BigDecimal(100));
        System.out.println(b);
        System.out.println(String.valueOf(b).chars().mapToLong(v -> Character.getNumericValue(v)).sum());
    }

    public static BigDecimal fact(BigDecimal val) {
        if(val.equals(new BigDecimal(1))) {
            return new BigDecimal(1);
        }
        BigDecimal result = fact(val.subtract(new BigDecimal(1)));
        return val.multiply(result);

    }
}
