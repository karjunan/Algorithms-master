package com.afterlongpractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Premutations {

    public static void main(String[] args) {
        char [] ch = new char[]{'a','b','c','d'};
        List<Character> input = new ArrayList<>();
        for(char ch1: ch) {
            input.add(ch1);
        }
        perm(0,ch);
      //  perm1(input,new ArrayList<>());

    }

    public static void intend(int val) {
        for(int i = 0 ; i < val; i++) {
            System.out.print("        ");
        }
    }

    public static void perm1(List<Character> input, List<Character> output) {
        intend(output.size());
        System.out.println(input + " >>> " + output);
        if(input.isEmpty()) {
            System.out.println(output);
            return;
        }

        for(int i = 0; i < input.size(); i++) {
            Character ch = input.remove(i);
            output.add(ch);
            perm1(input,output);
            Character ch1 = output.remove(output.size()-1);
            input.add(i,ch1);
        }

    }

    public static void perm(int start, char [] ch) {
        intend(start);
        System.out.println(Arrays.toString(ch));

        if(start == ch.length-1) {
            System.out.println(Arrays.toString(ch));
            return;
        }
        int i = start;
        System.out.println(i + " :: " + start);
        for(; i < ch.length; i++) {
            System.out.println("Values inside loop => " + i + " :: " + start);
            swap(ch,i,start);
            perm(start+1,ch);
            swap(ch,i,start);
        }
    }

    public static void swap(char [] ch, int i , int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
