package com.google;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GenerateNumbersWithGivenDigits {

    public static void main(String[] args) {
        generate(10);
    }

    public static void generate(int n) {

        int i = 0;
        List<String> list = new ArrayList<>();
        Deque<String> deque = new ArrayDeque<>();
        deque.add("5");
        deque.add("6");
        while(i < n) {
            String val = deque.poll();
            list.add(val);
            String left = val+"5";
            String right = val+"6";
            deque.add(left);
            deque.add(right);
            System.out.println(list);
            i++;
        }
        System.out.println(list);
    }
}
