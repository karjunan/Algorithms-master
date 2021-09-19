package com.afterlongpractise;

import java.util.Stack;

public class MinMaxStack {

    static Stack<MinMax> minMaxStack = new Stack<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        int [] input = new int [] {5,7,8,9,20,30,8,4};

        for(Integer val: input) {
            push(val);
        }
        System.out.println("Min max => " + min() + " :: " + max());
        System.out.println("Remnoved element => " + pop());
        System.out.println("Min max => " + min() + " :: " + max());
        System.out.println("Remnoved element => " + pop());
        System.out.println("Min max => " + min() + " :: " + max());
        push(100);
        push(1);
        System.out.println("Min max => " + min() + " :: " + max());
        System.out.println("Remnoved element => " + pop());
        System.out.println("Min max => " + min() + " :: " + max());
        System.out.println("Remnoved element => " + pop());
        System.out.println("Min max => " + min() + " :: " + max());
        System.out.println("Remnoved element => " + pop());
        System.out.println("Min max => " + min() + " :: " + max());
        System.out.println("Remnoved element => " + pop());
        System.out.println("Min max => " + min() + " :: " + max());
        System.out.println("Remnoved element => " + pop());
        System.out.println("Min max => " + min() + " :: " + max());
    }

    public static int peek() {
            return stack.isEmpty() ? -1 : stack.peek();
    }


    public static int pop() {
        int value = -1;
        if(!stack.isEmpty()) {
            minMaxStack.pop();
            value = stack.pop();
        }
        return value;
    }

    public static int min() {
        if(stack.isEmpty()) {
            return -1;
        }
        System.out.println("how can the size be different => " + stack.size() + " :: " + minMaxStack.size());
        return minMaxStack.peek().min;
    }

    public static int max() {
        if(stack.isEmpty()) {
            return -1;
        }
        return minMaxStack.peek().max;
    }

    public static void push(int integer) {

        if(minMaxStack.isEmpty()) {
            minMaxStack.push(new MinMax(integer, integer));
        } else {
            if(integer <= minMaxStack.peek().min ) {
                minMaxStack.push(new MinMax(integer, minMaxStack.peek().max));
            } else if(integer >= minMaxStack.peek().max) {
                minMaxStack.push(new MinMax(minMaxStack.peek().min, integer));
            } else {
                minMaxStack.push(new MinMax(minMaxStack.peek().min, minMaxStack.peek().max));
            }
        }
        System.out.println("Printing min max stack => " + minMaxStack);
        stack.push(integer);
    }

    static class MinMax {
        int min;
        int max;
        MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
        public String toString() {
          //  System.out.println("["+min+"-"+max+"]");
            return this.min + " :: " + this.max;
        }
    }

}
