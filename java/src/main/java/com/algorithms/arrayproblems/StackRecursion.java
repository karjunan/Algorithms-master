package com.algorithms.arrayproblems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalLong;
import java.util.Stack;
import java.util.stream.Stream;

public class StackRecursion {


    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(21);
        stack.push(12);
        stack.push(43);
        stack.push(1);
        stack.push(11);
        System.out.println(stack);
        System.out.println(sortStackWithAnotherStack(stack));

        String str;
        int i = 128;
        byte b = (byte)i;
        System.out.println(b);
        String s = "asdfa";
        String abc;

    }

    public static Stack<Integer> sortStackWithAnotherStack(Stack<Integer> stack) {
            Stack<Integer> temp = new Stack<Integer>();
            temp.push(stack.pop());
            while(!stack.isEmpty()) {
                int val = stack.pop();
                while(!temp.isEmpty() &&  val < temp.peek() ) {
                    stack.push(temp.pop());
                }
                if(!temp.isEmpty()  && temp.peek() < val) {
                    temp.push(val);
                }

                if(temp.isEmpty()) {
                    temp.push(val);
                }
            }
            return temp;
    }


    public static void sortStack(Stack<Integer> stack) {
        if(stack.isEmpty())
           return;
        int val = stack.pop();
        System.out.println(val + ":: " + stack);
        sortStack(stack);
        stackInsert(val,stack);
        System.out.println(val + ":: " + stack);

    }

    public static void stackInsert(int x, Stack<Integer> stack) {
        if(stack.isEmpty()) {
            stack.push(x);
            return;
        }

        if(x < stack.peek()) {
            stack.push(x);
            stackInsert(x,stack);
        } else {
             stack.pop();
        }

    }

}
