package com.algorithms.arrayproblems;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        final String str = "ABCDGH";
        final String str1 = "AEDFHR";
        lca(str, str1);
    }

//  bcdg
    //   ADH
    //     GTAB
    public static void lca(String str, String str1) {

        int row = str.length() + 2;
        int col = str1.length() + 2;
        char[][] arr = new char[row][col];

        for (int i = 2; i < row; i++) {
            arr[i][0] = str.charAt(i - 2);
            arr[i][1] = '0';
        }

        for (int j = 2; j < col; j++) {
            arr[0][j] = str1.charAt(j-2);
            arr[1][j] = '0';
        }

        print(arr);

        for( int i = 2 ; i < arr.length; i++) {
            for( int j = 2; j < arr[i].length;j++) {
                if(arr[i][0] == arr[0][j]) {

                    int a = Character.getNumericValue(arr[i][j-1]);
                    int b = Character.getNumericValue(arr[i-1][j]);
                    int val = Math.max(a,b);
                    ++val;
                    arr[i][j] = Character.forDigit(val,9);
                } else {
                    int a = Character.getNumericValue(arr[i][j-1]);
                    int b = Character.getNumericValue(arr[i-1][j]);
                    int val = Math.max(a,b);
                    arr[i][j] = Character.forDigit(val,9);
                }
            }
        }

        print(arr);

        int i = arr.length -1;
        int j = arr[i].length -1;
        while( true) {

               if(i < 2) {
                   break;
               }
               if(j < 2) {
                   break;
               }
                int val = Character.getNumericValue(arr[i-1][j]);
                int val1 = Character.getNumericValue(arr[i][j-1]);
                int max = Math.max(val,val1);
                if(Character.getNumericValue(arr[i][j]) == max) {
                    if(val < val1) {
                        j--;
//                        break;
                    } else {
                        i--;
                    }

                }
                if(Character.getNumericValue(arr[i][j]) > Character.getNumericValue(arr[i-1][j-1])) {
                    System.out.print(arr[0][j]);
                    i--;
                    j--;
                }
            System.out.println("  ");
        }

    }

    public static void print(char[][] ch) {
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                System.out.print("      " + ch[i][j]);
            }
            System.out.println("");
        }
    }
}
