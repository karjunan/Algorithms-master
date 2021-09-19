package com.string;

import java.util.Arrays;

public class StringNumberOfLines {
    static String str = "abcdefghijklmnopqrstuvwxyz";
    // static String str = "bbbcccdddaaa";
    static int [] width =       {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
// {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};

    public static void main(String [] args) {
        System.out.println(Arrays.toString(numberOfLines(str,width)));

    }
    // how  many lines have atleast one character from str;
    // what is the width of the last line

    public static int[] numberOfLines(String s, int [] width) {

        int totalSize = 0;
        int lineWidth = 0;
        int lines = 0;
        int i = 0;
        while(i < s.length()) {
            lineWidth = lineWidth + width[((int)s.charAt(i) - 97)];
            System.out.println(lineWidth);
            if(lineWidth < 100) {
                i++;
                continue;
            }else if(lineWidth == 100) {
                lines++;
                lineWidth = 0;
            } else if(lineWidth > 100) {
                lines++;
                lineWidth = 0;
                i--;
            }
            i++;
        }
        if(lineWidth > 0) {
            lines++;
        }

        int [] arr = new int[2];
        arr[0]  = lines;
        arr[1] = lineWidth;
        return arr;

    }


}
