package com.string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

//    static String str = "leetcode";
    static String str = "loveleetcode";
    public static void main(String[] args) {
        System.out.println("Output = " + firstUniqChar(str));
    }

    public static int firstUniqChar(String s) {

        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch,1);
            } else {
                Integer j = map.get(ch);
                j = j + 1;
                map.put(ch,j);
            }
            i++;
        }

        i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(map.get(ch) == 1) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
