package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LetterTilePossibilities {

    public static void main(String[] args) {
        String str = "AAABBC";
        HashSet<String> set = new HashSet<>();
        combinationEasy(str.toCharArray(),0,new ArrayList<>(), set);
        System.out.println(set);
        permutations(str.toCharArray(),0,set);

        System.out.println(set.size());

    }

    public static void permutations(char[] input, int start,HashSet<String> set) {
        if(start == input.length) {
            System.out.println(Arrays.toString(input));
            set.add(new String(input));
        }
        for(int i = start ; i < input.length; i++) {
                swap(input,start,i);
                permutations(input,start+1,set);
                swap(input,start,i);
        }

    }

    public static void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] =  temp;
    }

    public static void combinationEasy(char[] input, int pos, List<Character> r, HashSet<String> set) {

        StringBuffer buffer = new StringBuffer();
        for(Character c: r) {
            buffer.append(c);
            System.out.println(buffer.toString());
        }
        set.add(buffer.toString());
        System.out.println();
        for (int i = pos; i < input.length; i++) {
            if (i != pos && input[i] == input[i-1]) {
                continue;
            }
            r.add(input[i]);
            combinationEasy(input, i + 1, r,set);
            r.remove(r.size() - 1);
        }
    }
}
