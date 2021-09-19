package com.afterlongpractise;

public class FindDuplicateUsingBitWiseMasking {

    public static void main(String[] args) {

        String str = "finding";
        char [] ch = str.toCharArray();

        int temp = 0;
        for(int i = 0 ; i < ch.length; i++) {
            int x = 1;
            x = x << (int)ch[i] - 97;
            if((x & temp) > 0) {
                System.out.println(" the duplicate is " + ch[i]);
            } else {
                temp =  x | temp;
            }
        }

    }

}
