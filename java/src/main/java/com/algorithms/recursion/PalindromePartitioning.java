package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class PalindromePartitioning {

    public static void main(String [] ar) {

        String str = "bcc";
        palindromePart(str);
        // boolean bool = isPalindrome("mama");
        // System.out.println("is Palindrome " + bool);
    }

    public static void palindromePart(String str) {

        HashSet<String> ls = new HashSet<>();
        ArrayList<String> current = new ArrayList<>();

        for(char ch : str.toCharArray()) {
            current.add(Character.toString(ch));
        }
        ArrayList<String> next = new ArrayList<>();
        partition(current,next,ls,0);

        System.out.println(ls);
    }

    public static void partition(ArrayList<String> current, ArrayList<String> next,HashSet<String> ls, int val) {
        System.out.println(">>>>>>>" + next);
        for( int i = val; i < current.size(); i++) {
            next.add(current.get(i));
            String s = next.stream().collect(Collectors.joining());
            System.out.println(s);
            if(isPalindrome(s)) {
                ls.add(s);
            }
            partition(current,next,ls,i+1);
            next.clear();
        }

    }


    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length()-1;
        while(i <= j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

}
