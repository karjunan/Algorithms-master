package com.algorithms.leetCode;

import java.util.Arrays;

public class ReverseOnlyLetter {


    public static void main(String [] args) {

        String str = "Test1ng-Leet=code-Q!";
        String result = reverseOnlyLetters(str);
        System.out.println("Result is -> " + result);
        //Qedo1ct-eeLg=ntse-T!
    }

    public static String reverseOnlyLetters(String s) {

        int i = 0;
        int j = s.length()-1;
        char [] ch = s.toCharArray();
        String result = new String(reverse(ch,i,j));
        return result;

    }

    public static char[] reverse(char [] ch, int i, int j) {
        char [] buffer = new char[128];
        for( int k =(int)'a' ; k <=(int)'z'; k++ ) {
            buffer[k] = (char)k;
        }

        for( int k =(int)'A' ; k <=(int)'Z'; k++ ) {
            buffer[k] = (char)k;
        }

        System.out.println(Arrays.toString(buffer));
        while(i < j) {
            int start = (int)ch[i];
            int end =  (int)ch[j];

            if(buffer[start] != ch[i]) {
                i++;
                continue;
            }

            if(buffer[end] != ch[j]) {
                j--;
                continue;
            }

            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return  ch;
    }
}
