package com.algorithms.arrayproblems;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(22);
        stack.push(2);
        stack.push(5);
        sort(stack);
        System.out.println(stack);
    }

    public static void sort( Stack<Integer> stack ) {
        if(!stack.isEmpty()) {
            int element = stack.pop();
            sort(stack);
            sortedInsert(stack, element);
        }

    }

    private static void sortedInsert(Stack<Integer> stack, int element) {
        if(stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int current = stack.pop();
            sortedInsert(stack,element);
            stack.push(current);


        }

    }


}
