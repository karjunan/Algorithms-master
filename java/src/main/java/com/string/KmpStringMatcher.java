package com.string;

import java.util.Arrays;

public class KmpStringMatcher {

    static String original = "abxabcabcaby";
    static String pattern = "abxab";
    public static void main(String[] args) {

        String status = available(original,pattern);
        System.out.println( "Is the String present : " + status );
    }

    public static String available(String original,String patttern) {

        String str = "NO";

        int [] patternValue = constructPatternArray(patttern);
        int i = 0;
        int j = 0;

        char [] org = original.toCharArray();
        char [] pat = pattern.toCharArray();

        while( i < original.length() && j < pattern.length() ) {
            if(org[i] == pat[j]) {
                i++;
                j++;
            } else {
                if(j <= 0) {
                    j = 1;
                }
                int val = patternValue[(j-1)];
                if(val > 0) {
                    j = val;
                } else {
                    i++;
                    j = val;
                }

            }

            if(j == pat.length) {
                str = "YES";
            }
        }

        return  str;
    }

    public static int [] constructPatternArray(String  str) {

        int i = 1;
        int j = 0;
        char [] ch = str.toCharArray();
        int [] patternArray = new int[ch.length];
        System.out.println(Arrays.toString(patternArray));
        patternArray[0] = 0;
        while(i < str.length()) {
            if(ch[i] == ch[j]) {
                patternArray[i] = j+1;
                j++;
                i++;
            } else {
                if(j <= 0) {
                    j = 0;
                    patternArray[i] = 0;
                    i++;
                } else {
                    int val = j-1;
                    int indexVal = patternArray[val];
                    j = indexVal;
                }


            }
            System.out.println("Each Loop ::" + Arrays.toString(patternArray));
        }

        return patternArray;
    }

}
