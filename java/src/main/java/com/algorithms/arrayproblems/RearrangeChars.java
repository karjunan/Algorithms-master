package com.algorithms.arrayproblems;

import java.util.Arrays;

public class RearrangeChars {

    static String str = "bbbaa";

    public static void main(String args [] ) {

        String result = rearrange(str);
        System.out.println("Result is -> " + result );

    }


    public static String rearrange(String str) {
        int i = 0;
        char [] ch = str.toCharArray();
        StringBuffer buffer = new StringBuffer();
        while(i < ch.length) {
            int j = i + 1;
            while( i < ch.length  && j < ch.length) {
                if(ch[i] == ch[j]) {
                    j++;
                } else {
                    break;
                }
            }
            if(i < ch.length - 1 && j < ch.length) {
                char temp = ch[i+1];
                ch[i+1] = ch[j];
                ch[j] = temp;
            }
            i = i + 2;
            System.out.println(Arrays.toString(ch));
        }

        return new String(ch);
    }
}
