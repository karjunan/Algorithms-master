package com.algorithms.algoExpert;

public class LevenshteinsDistance {

    public static void main(String [] args) {

        String str = "abc";
        String str1 = "yabde";

        int result = levistineDistance(str,str1);

        System.out.println("Final Result -> " + result);

    }

    public static int levistineDistance(String str, String str1) {

        int [][] arr = new int [str.length() + 1][str1.length()+1];


        for(int i = 0 ; i < arr.length;i++) {
            arr[i][0] = i;
        }

        for(int i = 0 ; i < arr[0].length;i++) {
            arr[0][i] = i;
        }

        int min = 0;
        int row = 0;
        for( int i = 1; i < arr.length; i++) {
            int col = 0;
            for( int j = 1 ; j < arr[i].length; j++) {
                char rowChar = str.charAt(row);
                char colChar = str1.charAt(col);
                if(rowChar == colChar) {
                    min = arr[i-1][j-1];
                    arr[i][j] = min;
                } else if(rowChar != colChar) {
                    int localMin = Math.min(arr[i-1][j],arr[i][j-1]);
                    localMin = Math.min(localMin,arr[i-1][j-1]);
                    min = localMin;
                    arr[i][j] = min+1;

                }
                col++;
            }
            row++;
        }
        int rowEnd = arr.length-1;
        int colEnd = arr[0].length-1;
        return arr[rowEnd][colEnd];
    }

    public static void print(int [][] arr) {
        for( int i = 0 ; i < arr.length; i++) {
            for( int j = 0 ; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

    }


}
