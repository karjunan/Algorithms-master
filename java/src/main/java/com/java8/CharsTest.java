package com.java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class CharsTest {
    public static void main(String[] args) {
        String str = "123";

        int val = Arrays.stream(str.split("")).mapToInt(Integer::valueOf).sum();

         val = Stream.of(str.split("")).mapToInt(Integer::valueOf).sum();

        System.out.println(val);
//        System.out.println(IntStream.of(str.chars().toArray()).sum());

    }
}
