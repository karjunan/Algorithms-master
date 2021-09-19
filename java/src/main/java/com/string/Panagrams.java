package com.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Panagrams {
    // static String str = "The quick brown fox jumps over the lazy dog";
    static String str = "The quick brown fox jumps over the dog";
    public static void main(String[] args) {

        boolean bool =  panagram(str);
        System.out.println("Is Panagram : " + bool);
    }

    public static boolean panagram1(String str) {
        boolean [] bool = new boolean[26];

        int lindex = (int)'a';
        int hindex = (int)'A';
        System.out.println(lindex + " -- "+ hindex );
        int position = 0;
        for( int i = 0 ; i < str.length(); i++) {
            char ch = str.charAt(i);
            if((int)ch < 97 && (int)ch != ' ') {
                position = (int)ch + 32;
                System.out.println(" Calculate position -> " +  (position-97)) ;
                bool[position-97] = true;
            } else if((int)ch >= 97 && (int)ch != ' ') {
                bool[(int)str.charAt(i) - 97] = true;
            }
        }
        System.out.println(Arrays.toString(bool));

        for( int i = 0 ; i < bool.length; i++) {
            if(bool[i] == false) {
                return false;
            }
        }
        return true;
    }


    public static boolean panagram(String str) {
        Map<Character, Boolean> map = new HashMap<>();
        char ch = 'a';
        int i = (int)ch;
        int end = (i+26);
        while(i < end) {
            map.put((char)i,false);
            i++;
        }

        int k = 0 ;
        while(k < str.length()) {
            if(map.containsKey(str.charAt(k))) {
                map.put(str.charAt(k), true);
            }
            k++;
        }
        // System.out.println(map);

        k = 0;

        for(Map.Entry<Character,Boolean> entry : map.entrySet()) {
            if(entry.getValue() == false) {
                return false;
            }
        }
        return true;
    }
}
