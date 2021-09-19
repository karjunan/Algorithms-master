package com.algorithms.arrayproblems;

public class PowerOf10 {

    public static void main(String [] args) {
        try {
            System.out.println(power(10,2));
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static long power(int base, int exp) throws Exception{

        if(exp == 0 ) {
            return 1;
        } else if( exp < 0) {
            throw new Exception("Negative number are not allowed");
        }
        else {

            return base * power(base,--exp);
        }
    }
}
