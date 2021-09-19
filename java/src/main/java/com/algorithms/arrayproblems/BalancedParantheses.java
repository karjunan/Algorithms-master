package com.algorithms.arrayproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParantheses {

    static String str = ")()}";
    public static void main(String[] args) {

        boolean result = balancedParantheses(str);
        System.out.println("Boolean -> " + result);

    }

    public static boolean balancedParantheses(String s ) {

        String openBrases = "{[(";
        String closingBrases = "}])";
        Map<String,String> map = new HashMap<>();
        map.put("]","[");
        map.put("}","{");
        map.put(")","(");

        Stack<String> stack = new Stack<>();
        int i = 0;
        boolean bool = false;
        while(i < s.length()) {
            String s1 = Character.toString(s.charAt(i));
            if(openBrases.contains(s1)) {
                stack.push(s1);
                i++;
                continue;
            } else {

                System.out.println("S1  --> " + s1);
                String s2 = " ";
                String ch = "";

                if(!stack.isEmpty() && map.containsKey(s1)) {
                    s2 = stack.pop();
                    ch = map.get(s1);
                    System.out.println(s2 + " = " + ch );
                }

                if(!s2.equals(ch)) {
                    return false;
                }

            }
            i++;
        }


        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
