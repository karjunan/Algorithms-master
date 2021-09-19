package com.string;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BoyerMoreAlogrithm {


    static String str     ="krishna and lokesh";
    static String pattern ="nan";

    public static void main(String[] args) {

        System.out.println(match(str,pattern));

    }


    public static boolean match(String str, String pattern) {
        Map<Character,Integer> map = badMatchTable(pattern);

        int pStart = 0;
        int pEnd = pattern.length() - 1;
        int sStart = 0;
        int sEnd = pattern.length() -1;
        int current = pattern.length();
        List<Character> list = new ArrayList<>();

        while(sEnd < str.length()) {
            while( pStart <= pEnd &&  sEnd < str.length() ) {
                if(pattern.charAt(pEnd) == str.charAt(sEnd)) {
                    list.add(pattern.charAt(pEnd));
                    pEnd--;
                    sEnd--;
                } else {
                    list  = new ArrayList<>();
                    pStart = 0;
                    pEnd = pattern.length()-1;
                    if(map.containsKey(str.charAt(sEnd))) {
                        int val = map.get(str.charAt(sEnd));
                        sStart = sStart + val;
                        sEnd = sEnd + val;
                    }  else {
                        sStart = current;
                        current = (current + pattern.length());
                        sEnd = (current-1);
                    }
                    break;
                }
            }
            System.out.println(list.size() +":: "+ pattern.length() + " >>" + current + " >>" + str.length() + ">>" + list);

            if(list.size() == pattern.length()) {
                return true;
            }

        }
        return false;

    }



    public static Map<Character,Integer> badMatchTable(String pattern) {

        Map<Character,Integer> map = new HashMap<>();
        for( int i = 0; i < pattern.length()-1; i++) {
            final int val = i;
            map.compute(pattern.charAt(i), (k,v) -> v == null ? (pattern.length() - val) -1 : (pattern.length()-val)-1);
        }

        map.put('?',5);

        System.out.println(map);
        return map;
    }
}
