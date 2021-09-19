package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class LetterCasePermutation {

    public static void main(String [] args) {
        String s = "a1b2";
        HashSet<String> set = new HashSet();
        helper(s.toCharArray(), 0, set);
        System.out.println(set);
        List<String> str = new ArrayList<>(set);

    }

    public static void helper(char[] ch, int idx, HashSet<String> set) {
        if(idx == ch.length) {
            System.out.println(Arrays.toString(ch));
            set.add(new String(ch));
            return;
        }

       helper(ch,idx+1,set);
       if(Character.isLetter(ch[idx])) {
            ch[idx] = Character.toUpperCase(ch[idx]);
            helper(ch, idx+1, set);
            ch[idx] = Character.toLowerCase(ch[idx]);
        }
        
    }
    
}
