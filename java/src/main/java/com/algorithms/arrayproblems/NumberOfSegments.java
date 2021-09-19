package com.algorithms.arrayproblems;

import java.util.Stack;

public class NumberOfSegments {

    public static void main(String [] ar) {
        // String str =  ", , , ,        a, eaefa";
        String str = "Hello, my name is John";
        //result = 6
        int counter = numberOfSegments(str);
        System.out.println(counter);
    }

    public static int numberOfSegments(String str) {

        int i = 0;
        int counter = 0;
        Stack<Character> stack = new Stack<>();
        boolean bool = false;
        while(i < str.length()) {
            if(str.charAt(i) != ' ') {
                stack.push(str.charAt(i));
                i++;
                bool = false;
                continue;
            }

            while(str.charAt(i) == ' ' && !stack.isEmpty()) {
                bool = true;
                stack.pop();
            }

            if(bool) {
                counter++;
                bool = false;
            }
            i++;
        }

        if(!stack.isEmpty()) {
            counter++;
        }

        return counter;
    }
}
