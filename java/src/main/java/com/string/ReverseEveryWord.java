package com.string;

import java.util.Arrays;

public class ReverseEveryWord {
    static String str = "Let's take LeetCode contest";
    // static String str = "III";
    // static String str = "DDI";
    public static void main(String [] args) {
        reverseWords(str);

    }

    public static void reverseWords(String str) {
        int i = 0;
        int j = 1;
        char ch  [] = str.toCharArray();
        System.out.println(Arrays.toString(ch));

        while(i < j && i < str.length()) {

            while(j < str.length() && str.charAt(j) != ' ') {
                j++;
            }

            ch = reverse(ch,i,j-1);
            i = j + 1;
            j = j+2;


        }

    }

    public static char [] reverse(char [] ch ,int start, int end ) {

        while(start  <= (start+end)/2) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(ch));
        return ch;
    }

}
