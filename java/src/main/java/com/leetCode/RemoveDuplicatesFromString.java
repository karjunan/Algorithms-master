package com.leetCode;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromString {

    public static void main(String [] args) {

        String str = "abbaca";
        // String result = removeDuplicates(str);
        // System.out.println("Result is -> " + result);

        String result = removeDuplicatesOptimized(str);
        System.out.println("Result is -> " + result);


    }
  /*
    itr 1 -> [a,b]
    itr 2 -> [a]
    itr 3 -> []
    itr4 ->

  */

    public static String removeDuplicatesOptimized(String str) {
        if(str.isEmpty()) {
            return "";
        }

        Stack<String> stack = new Stack<>();
        String val = Character.toString(str.charAt(0));
        stack.push(val);
        for( int i = 1 ; i < str.length(); i++) {

            val = Character.toString(str.charAt(i));

            if(!stack.isEmpty()) {
                String result = stack.peek();
                if(!result.equals(val)) {
                    stack.push(val);
                } else {
                    stack.pop();
                }

            } else {
                stack.push(val);
            }

        }
        return stack.stream().collect(Collectors.joining(""));
    }

    public static String removeDuplicates(String str ) {

        for( int i = 0 ; i < str.length(); i++) {
            for( int j = 0 ; j < str.length() - 1 ; j++) {
                System.out.println(" Result -> " + str);
                if(str.charAt(j) == str.charAt(j+1)) {
                    String firstString = str.substring(0,j);
                    String secondString = str.substring(j+2,str.length());
                    str = firstString + secondString;
                    System.out.println(str);
                }
            }
        }

        if(str.length() == 2) {
            if(str.charAt(0) == str.charAt(1) ){
                return "";
            }
        }
        return str;
    }

}
