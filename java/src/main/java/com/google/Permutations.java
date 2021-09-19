package com.google;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Permutations {

    public static void main(String[] args) {

        List<String> input = new ArrayList<>();
        input.add("a");
        input.add("b");
        input.add("c");
//        input.add("d");
        List<String> output = new ArrayList<>();

//        helper(input,output);
        helper1(input,0);
    }

    public static void helper1(List<String> input, int pos) {
        if(pos == input.size()) {
            System.out.println(input);
            return;
        }

        for(int i = pos; i < input.size(); i++) {
            swap(input,i,pos);
            helper1(input,pos+1);
            swap(input,i,pos);
        }
    }


    private static void swap(List<String> input, int i, int j) {
        String temp  = input.get(i);
        input.set(i,input.get(j));
        input.set(j,temp);
    }

    public static void helper(List<String> input, List<String> output) {

        if(input.isEmpty()) {
            System.out.println(output);
            return;
        }

        for(int i = 0 ; i < input.size(); i++) {
            String val = input.get(i);
            input.remove(val);
            output.add(val);
            helper(input,output);
            input.add(i,val);
            output.remove(val);
        }

    }

}
