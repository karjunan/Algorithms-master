package com.algorithms.arrayproblems;

import java.util.Stack;
import java.util.stream.Stream;

class ReverseStack {

    public static void main(String [] args) {

        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        println(stack);

        reverseStack(stack);

        println(stack);
    }

    public static Integer reverseStack(Stack<Integer> stack) {

        if(stack.isEmpty()) {
            return 0;
        }
        Integer val = stack.pop();
        reverseStack(stack);
        stack.push(val);
        return val;
    }

    public static void println(Stack<Integer> stack) {
        Stream.of(stack).forEach(System.out::println);

    }
}

