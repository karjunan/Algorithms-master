package com.practise2;

public class RodCuttingRecurssion {

    public static void main(String[] args) {
        int[] price = new int[]{1,5,8,9,10,17,17,20};
        int val = recurse(price,1, price.length-1);
        System.out.println("Is this the right val => " + val);
    }

    private static int recurse(int[] price, int pos, int length) {
        System.out.println(length + " === " + pos);
        if(length < 0) {
            return Integer.MIN_VALUE;
        }

        if(length == 0) {
           return 0;
       }
       int max = Integer.MIN_VALUE;

       return Math.max(max , price[pos] + recurse(price,pos,length-pos));
    }
}
