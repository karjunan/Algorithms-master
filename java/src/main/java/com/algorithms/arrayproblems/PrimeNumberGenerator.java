package com.algorithms.arrayproblems;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class PrimeNumberGenerator {

    public static void main(String[] args) {

    }

    public static boolean findPrime(int val) {

        boolean bool = false;
        if(val == 1 || val == 2 || val == 3) {
            bool = true;
        } else {
            OptionalInt optionalInt = IntStream.range(4,val-1)
                    .filter(v -> ((v % val) == 0))
                    .peek(v -> System.out.println(v))
                    .findAny();

            if(optionalInt.isPresent()) {
                bool = false;
            }
        }

        return bool;
    }
}
