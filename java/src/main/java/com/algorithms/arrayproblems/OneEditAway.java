package com.algorithms.arrayproblems;

import java.util.HashMap;
import java.util.Map;

public class OneEditAway {

    static String [] str = {"apple" , "aple"};
    // static String [] str = { "pales" , "pale"};
    // static String [] str = {"pale" , "bale"};
    // static String [] str = {"pale" , "bae"};
    // insert, delete , replace

    public static void main(String [] args) {

        boolean result = edits(str);
        System.out.println("Can be edited in on move >> " + result);

    }

    public static boolean edits(String [] str ) {

        int i = 0;
        Map<Character,Integer> map = new HashMap<>();
        int j = 0;
        while(j < str[i].length()) {
            Character ch = str[i].charAt(j);
            if(map.containsKey(ch)) {
                Integer val = map.get(ch);
                map.put(ch, val+1);
            } else {
                map.put(ch,1);
            }
            j++;
        }
        System.out.println(map);

        i = 0;
        while( i < str[1].length()) {
            if(map.containsKey(str[1].charAt(i))) {
                Integer result = map.get(str[1].charAt(i));
                if(result == 1) {
                    map.remove(str[1].charAt(i));
                } else {
                    map.put(str[1].charAt(i),result-1);
                }
            }
            i++;
        }
        System.out.println(map);
        if(map.size() == 1 || map.size() == 0) {
            return true;
        }
        return false;
    }

}
