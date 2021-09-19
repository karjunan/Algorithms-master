package com.string;

import java.util.Arrays;

public class KmpPatternBuilder {

//    static String str = "acacabacacabacacac";

    static String str = "abcdabca";

    public static void main(String[] args) {

        System.out.println("length of string : " + str.length());
            int [] pattern = constructPatternArray(str);
        System.out.println(Arrays.toString(pattern));

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
