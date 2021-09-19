package com.cyrptography;

import java.util.Random;
import java.util.stream.IntStream;

public class PseudoRandomNumber {

    public static void main(String[] args) {
        Random random = new Random();
        IntStream.range(0,10)
                .forEach(v ->
                        System.out.println("Random number : " + random.nextInt(100000)));
    }
}
