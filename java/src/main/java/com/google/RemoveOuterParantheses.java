package com.google;

import java.util.Stack;

public class RemoveOuterParantheses {


    public static void main(String[] args) {
        String s = "(()())(())";
        removeOuterParentheses(s);
    }

    public static  String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty() && c == '(') {
                stack.push(c);
                continue;
            }

            System.out.println(stack.size());

            if (stack.size() == 1 && c == ')') {
                stack.pop();
                continue;
            }

            if (c == '(') {
                stack.push(c);
            }

            if (c == ')') {
                stack.pop();
            }
            result += c + "";
            System.out.println("Result is => " + result);
        }

        return result;
    }
}
