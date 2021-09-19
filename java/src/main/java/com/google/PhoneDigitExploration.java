package com.google;

import java.util.ArrayList;
import java.util.List;

public class PhoneDigitExploration {

    public static void main(String[] args) {

        List<String> input = new ArrayList<>();
        input.add("0");
        input.add("1");
        input.add("abc");
        input.add("def");
        input.add("ghi");
        input.add("jkl");
        input.add("mko");
        input.add("pqrs");
        input.add("tuv");
        input.add("wxyz");

        List<Character> output = new ArrayList<>();
        String pressed = "2376";
        helper(input,output,pressed,0);

    }

    public static void helper(List<String> input,List<Character>                             output,String pressed,int digit) {

        if(digit == pressed.length() ) {
            System.out.println("Result is => " + output);
            return;
        }

        char ch = pressed.charAt(digit);
        int val = Character.getNumericValue(ch);
        String str = input.get(val);

        for( int i = 0 ; i < str.length() ;i++) {
            char c1 = str.charAt(i);
            output.add(c1);
            helper(input,output,pressed,digit+1);
            output.remove(new Character(c1));
        }

    }
}
