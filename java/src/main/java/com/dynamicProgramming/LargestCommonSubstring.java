package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class LargestCommonSubstring {

    public static void main(String[] args) {

//        String str = "abcdefasdf";
//        String str1 = "abfa";
        int i = 0;
        int j = 0;
//        System.out.println("\n\n Size " +
//                "is :: " + lcsRecursion(str, str1, i, j));

        String str = "aabcdefklmnopabcdefghijk";
        String str1 = "abcde";

        System.out.println("First String " + str);
        System.out.println("Second String " + str1);

        if (str.length() > str1.length()) {
            lcsCharacter(str, str1);
        } else {
            lcsCharacter(str1, str);
        }
//        lcs(str,str1);
    }

    public static int lcsRecursion(String str, String st1,int i , int j) {
        if(i == str.length() || j == st1.length())
        {
            return 0;
        }
        if(str.charAt(i) != st1.charAt(j)) {
            return lcsRecursion(str,st1,++i,j);
        }

        if(str.charAt(i) == st1.charAt(j)) {
            System.out.print("  "+str.charAt(i));
            return 1 + lcsRecursion(str,st1,++i,++j);
        }

        return 0;
    }

    public static int lcs (String str, String str1) {

        int[][] arr = new int[str.length() + 1 ][str1.length() + 1];

        int row = arr.length;
        int column = arr[0].length;

        for(int i = 0 ; i < column; i++) {
            arr[0][i] = 0;
        }

        for(int i = 0 ; i < arr.length; i++) {
            arr[i][0] = 0;
        }

        StringBuffer buffer = new StringBuffer();
        for(int i = 1 ; i < str.length(); i++) {
            for(int j = 1 ; j <= str1.length();j++) {
                if(str.charAt(i) == str.charAt(j)) {
                    buffer.append(str.charAt(i));
                    arr[i][j] =  (arr[i-1][j-1]) + 1;
                }

            }
        }

        // print(arr);
        System.out.println(buffer.toString());

        return buffer.toString().length();
    }


    public static void lcsCharacter(String str, String str1) {

        System.out.println(str + " ::: " + str1);

        char [][] ch = new char[str.length()+2][str1.length() + 2];
        int count = 0;
        ch[1][1] = '0';
        for(int i = 2 ; i < ch.length;i++) {
            ch[i][0] = str.charAt(count);
            ch[i][1] = '0';
            count++;
        }

        int count1 = 0;
        for(int i = 2 ; i < ch[str1.length()].length;i++) {
            ch[0][i] = str1.charAt(count1);
            ch[1][i] = '0';
            count1++;
        }


        print(ch);

        List<Character> list = new ArrayList<>();
        int max = 0;
        int iMax = 0;
        int jMax = 0;
        for(int i = 2 ; i < ch.length; i++) {
            for(int j = 2 ; j < ch[i].length; j++) {
                char rowValue = ch[i][0];
                char colValue = ch[0][j];

                if(rowValue == colValue) {
                    // System.out.println("Prv : " + ch[i-1][j-1]);
                    if(ch[i-1][j-1] != '0' ) {
                        int val = Character.getNumericValue(ch[i-1][j-1]);
                        val = val + 1;
                        String st = Integer.toString(val,10);
                        ch[i][j] = st.charAt(0);
                        list.add(ch[0][j]);
                        if(max < Character.getNumericValue(ch[i][j])){
                            iMax  = i;
                            jMax = j;
                        }
                    } else {
                        ch[i][j] = '1';
                    }
                } else {
                    ch[i][j] = '0';
                }
            }
        }

        print(ch);

        System.out.println("IMax " + iMax + " :  " + jMax);
        while(iMax > 1 && jMax > 1) {
            char val = ch[0][jMax];
            System.out.print( " " +val);
            iMax = iMax-1;
            jMax = jMax-1;

        }

    }

    public static void print(int [][] arr) {

        for(int i = 0 ; i < arr.length; i++) {
            for(int j = 0 ; j < arr[i].length; j++) {
                System.out.print("  " +arr[i][j] );
            }
            System.out.println("");
        }
    }

    public static void print(char [][] arr) {

        for(int i = 0 ; i < arr.length; i++) {
            for(int j = 0 ; j < arr[i].length; j++) {
                System.out.print("   " + arr[i][j] );
            }
            System.out.println("");
        }
    }
}
