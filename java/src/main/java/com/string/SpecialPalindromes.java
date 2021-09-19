package com.string;

import java.util.ArrayList;
import java.util.List;

public class SpecialPalindromes {

    static String str = "cbbabbc";
    // static String str = "abcbaba";
    // static String str = "mnonopoo";
    // static String str = "aaaa";
    // static String str = "ccacacabccacabaaaabbcbcc";

    public static void main(String[] args) {

        palindrome(str);
        boolean bool =  checkPalindrome(str);
        System.out.println("This is palindrome -> " + bool);
    }

    public static void palindrome(String str) {

        int i = 0;
        int j = 1;
        List<String> list = new ArrayList<>();
        while( i < str.length() && i < j) {
            String ch = Character.toString(str.charAt(i));
            StringBuffer buffer = new StringBuffer();
            buffer.append(ch);
            list.add(buffer.toString());
            j = i + 1;
            int counter = 0;
            while( j < str.length()) {
                buffer.append(Character.toString(str.charAt(j)));
                if(counter >= 3 && !checkPalindrome(buffer.toString())) {
                    break;
                } else if(checkPalindrome(buffer.toString())) {
                    list.add(buffer.toString());

                }
                // System.out.println("Counter = " + counter);
                counter++;
                j++;
            }
            i++;

        }
        System.out.println(list);
        System.out.println( "List Size -> " + list.size());


    }

    public static boolean checkPalindrome(String s) {
        int j = s.length()-1;
        int i = 0;
        char ch = s.charAt(i);
        while( i < j) {
            if(s.charAt(i) == s.charAt(j) && ch == s.charAt(j)
                    && ch == s.charAt(i)) {
                i++;
                j--;
                continue;
            } else {
                return false;
            }


        }
        return true;
    }

}
