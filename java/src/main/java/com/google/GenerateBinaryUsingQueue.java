package com.google;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class GenerateBinaryUsingQueue {

    public static void main(String[] args) {
        System.out.println(generate(10));
    }

    public static List<String> generate(long n) {

        List<String> list = new ArrayList<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.add("1");
        int i = 0;
        while(i <= n) {
            String s = queue.poll();
            list.add(s);
            String left = s+"0";
            String right = s+"1";
            queue.add(left);
            queue.add(right);
            i++;
            System.out.println(list);
//            System.out.println(queue);
            System.out.println("----------");
        }
        return list;
    }
}
