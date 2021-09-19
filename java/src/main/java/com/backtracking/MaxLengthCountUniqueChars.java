package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxLengthCountUniqueChars {
    
    public static void main(String [] args) {
        int [] result = new int[1];
        List<String> list = new ArrayList<>();
        list.add("un");
        list.add("iq");
        list.add("ue");
        dfs(list,"",0,result);
        System.out.println(Arrays.toString(result));

    }

    public static void dfs(List<String> input, String current, int start, int [] result) {
        System.out.println(current);
        if(start == input.size() && uniqueCharCount(current) > result[0]) {
            result[0] = current.length();
            return;
        }

        if(start == input.size()) {
            return;
        }

        dfs(input,current,start + 1, result);
        dfs(input,current+input.get(start), start+1, result);

    }

    public static int uniqueCharCount(String current) {
        int [] ch = new int[26];
        for(char c: current.toCharArray()) {
            if( ch[c - 'a']  > 0 ) {
                return -1;
            }
            ch[c-'a']++;
        }

        /*
            a = 65
            u = 117
            117 - 65 = 
        */
        return current.length();
    }

}
