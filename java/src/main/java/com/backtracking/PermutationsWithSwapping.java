package com.backtracking;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class PermutationsWithSwapping {
    

    public static void main(String [] args) {
         
        char [] ch = {'a','c','c'};
        List<Character[]> list = new ArrayList<>();
        permute(ch, 0, list);
        System.out.println(list.size());
    }

    public static void permute(char [] ch, int cid, List<Character[]> list) {
         if(cid == ch.length - 1) {
             System.out.println(Arrays.toString(ch));
            //  Stream<Character> charStream = IntStream.range(0, ch.length).mapToObj(v -> ch[v]);
            //  Character [] c1 = charStream.toArray(Character[]::new);
            //  list.add(c1);
             return;
         }
         for(int i = cid ; i < ch.length; i++) {    
                swap(ch,i,cid);
                permute(ch, cid+1, list);
                swap(ch,i,cid);
        }
    }

    public static void swap(char [] ch, int l, int r) {
         char ch1 = ch[l];
         ch[l] = ch[r];
         ch[r] = ch1;
    }
}
