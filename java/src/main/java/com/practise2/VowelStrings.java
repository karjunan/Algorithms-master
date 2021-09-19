package com.practise2;

import java.util.ArrayList;
import java.util.List;

public class VowelStrings {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        helper(33,0,"aeiou","",list);
        System.out.println(list);
        System.out.println("Total size is ==> " + list.size());
    }

    public static void helper(int n, int pos, String vowels, String temp, List<String> list) {

        if(n == 0) {
            System.out.println(temp);
            list.add(temp);
            return;
        }

        for(int i = pos; i < vowels.length(); i++) {
            String current = temp + Character.toString(vowels.charAt(i));
            helper(n-1,i,vowels,current,list);
            current = current.substring(0, current.length()-1);
        }

    }
}
