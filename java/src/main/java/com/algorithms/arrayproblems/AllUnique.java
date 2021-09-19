package com.algorithms.arrayproblems;

import java.util.Arrays;

public class AllUnique {

    public static void main(String[] args) {


        String str = "aa";

        // boolean bool = allUnique(str);

        boolean bool = allUniqueSpace(str);

        System.out.println("is Unique >>" + bool);

    }


    public static boolean allUniqueSpace(String str) {

        boolean [] bool = new boolean[256];

        for( int i = 0 ; i < str.length(); i++) {
            int val = (int)str.charAt(i);
            if(!bool[val]) {
                bool[val] = true;
            } else {
                return false;
            }
        }
        return true;

    }

    public static boolean allUnique(String str) {

        char [] ch = str.toCharArray();
        Arrays.sort(ch);
        System.out.println(Arrays.toString(ch));
        int i = 0;
        int j = 1;
        while(j < ch.length) {
            if(ch[i] == ch[j]){
                return false;
            }
            i++;
            j++;
        }

        return true;
    }

}
