package com.geeksForgeeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeftMostRepeatingCharacter {

    public static void main(String[] args) {

        String s = "geeksforgeeks";
//        String s = "abbcc";
//        String s = "abcd";
//        String s = "abccb";
        System.out.println("Index is  => " + leftMostRepeating(s) );
        System.out.println("Index from right to left => "+ leftMostVisited(s));
    }

    public static int leftMostRepeating(String str) {
        char [] ch = str.toCharArray();
        Map <Character,Integer> map = new HashMap<>();
        for(char c: ch) {
            map.compute(c, (k,v) -> v == null ? 1: v+1);
        }
        int index = 0;
        for(char c: ch) {
            if(map.get(c) > 1) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int leftMostVisited(String str) {
        char [] ch = str.toCharArray();

        boolean [] visited = new boolean[256];
//        System.out.println(Arrays.toString(visited));
        int i = Integer.MAX_VALUE;

        for( int k = ch.length-1; k >= 0; k-- ) {
            if(!visited[(int)(ch[k])]) {
                visited[(int)(ch[k])] = true;
            } else {
                i = k;
            }
        }

        return i == Integer.MAX_VALUE ? -1 : i;
    }
}
