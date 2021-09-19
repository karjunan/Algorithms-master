package com.algorithms.arrayproblems;

import java.util.Stack;

public class QueueUsingStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        enqueue(stack,1);
        enqueue(stack,2);
        enqueue(stack,3);
        enqueue(stack,4);
        System.out.println(stack);
        dequeue(stack,1);
        dequeue(stack,1);
        dequeue(stack,1);
        System.out.println(stack);

    }

    private static void enqueue(Stack<Integer> stack, int val) {
        stack.push(val);
    }

    private  static int dequeue(Stack<Integer> stack, int len) {
        if(stack.size() == 1) {
            return stack.pop();
        } else {
            int val = stack.pop();
            dequeue(stack,++len);
            stack.push(val);
            return val;
        }
    }
}
