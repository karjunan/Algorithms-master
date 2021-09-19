package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationAndCombination {

    static List list = new ArrayList();
    public static void main(String[] args) {

        String str = "ab";
        String str1 = "";
        perm(str,str1);
    }

    private static void perm( String str, String finalStr) {

        //Base case
        if(str.isEmpty()) {
            System.out.println("Output ::::::::  " +finalStr);
            return;
        } else {
            for(int i = 0; i < str.length(); i++) {
                String currentString = str.substring(0,i) + str.substring((i+1),str.length());
                finalStr = finalStr+str.charAt(i);
                //explore
                perm(currentString, finalStr);
                finalStr = finalStr.substring(0,finalStr.length()-1);

            }

        }

    }


    private static void swap(int i, int j, char [] ch) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }


}
