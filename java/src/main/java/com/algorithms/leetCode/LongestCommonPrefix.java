package com.algorithms.leetCode;

public class LongestCommonPrefix {

    public static void main(String [] ar) {

        String [] str = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(str));

    }

    public static String longestCommonPrefix(String[] str) {
        if(str.length == 0) {
            return "";
        }
        if(str.length == 1) {
            return str[0];
        }
        int index = 0;
        int length = Integer.MAX_VALUE;
        for(int i = 0 ; i < str.length; i++) {
            if(str[i].length() < length){
                length = str[i].length();
                index = i;
            }
        }

        String first = str[index];
        String prefix = "";

        for(int i = 0 ; i < str.length; i++) {
            if(index == i) {
                continue;
            }
            char [] ch = str[i].toCharArray();
            prefix = "";
            for( int j = 0 ; j < first.length(); j++) {
                if(ch[j] == first.charAt(j)) {
                    prefix += ch[j];
                } else {
                    break;
                }
            }
            first = prefix;
        }

        return prefix;
    }


}
