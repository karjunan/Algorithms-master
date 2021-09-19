package com.algorithms.arrayproblems;

import java.util.stream.Stream;

public class DecodingMessages {

    static String str = "ABC";

    public static void main(String[] args) {
        char [] charArray = new char[26];
        int [] arr = {1,2,3,4};
        int count = 0;
          for(int i = 65 ; i < 91; i++) {
            charArray[count] = (char)i;
            count++;
        }
        int outerLoop = 0;
          int valid = 1;
        while(outerLoop < str.length() - 1) {
            int innerLoop = outerLoop;


        }


        Stream.of(charArray).forEach(System.out::println);

    }
}
