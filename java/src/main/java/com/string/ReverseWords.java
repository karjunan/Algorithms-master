package com.string;

import java.util.Arrays;

public class ReverseWords {
    static String str = "Awesome string";

    public static void main(String[] args) {

        String s = reverseAll(str);
        System.out.println(s);
    }

    public static String reverseAll(String str ){
        char [] ch = str.toCharArray();
        System.out.println(Arrays.toString(ch));
        ch = reverse(ch,0,ch.length-1);
        int i = 0;
        int j = 0;
        System.out.println(Arrays.toString(ch));
        while(j < ch.length) {
            if(j < ch.length && ch[j] == ' ') {
                reverse(ch, i , j-1);
                i = j+1;
            }

            j++;
        }
        reverse(ch,i,j-1);
        System.out.println(Arrays.toString(ch));
        return new String(ch);
    }

    public static char [] reverse(char ch[], int low, int high) {

        int len = (low+high)/2;
        while(low <= len) {
            char temp = ch[low];
            ch[low] = ch[high];
            ch[high] = temp;
            low++;
            high--;
        }
        return ch;
    }
}
