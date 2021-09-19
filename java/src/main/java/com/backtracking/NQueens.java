package com.backtracking;

public class NQueens {

    public static void main(String [] ar) {

        int [][] arr = new int[4][4];
        // print(arr);

        NQueens(arr,0);
        System.out.println("----------- Final output is ----------");
        print(arr);
    }

    public static boolean NQueens(int [][] arr, int row) {

        if(row >= arr.length  ) {

            print(arr);
            return true;
        }

        boolean allPlaced = false;
        for ( int i = 0 ; i < arr.length; i++ ) {

            print(arr);
            boolean bool = isValid(arr,row,i);
            System.out.println("Valid placement >>  " + bool);
            if(bool) {
                arr[row][i] = 1;
                allPlaced = NQueens(arr,row+1);
            }

            if(allPlaced) {
                break;
            } else {
                arr[row][i] = 0;
            }
        }

        return allPlaced;
    }

    public static boolean isValid(int [][] arr, int row, int col) {
        System.out.println("Row >>" + row + " :  Col>> "+ col);
        int val = 0;
        if(col > 0) {
            for( int i = col; i >= 0 ; i-- ) {
                if(arr[row][i] == 1) {
                    val = 1;
                    System.out.println("Failed in >> " + val);
                    return false;
                }
            }
        }

        if(row > 0) {
            for( int i = row; i >= 0 ; i-- ) {
                if(arr[i][col] == 1) {
                    val = 2;
                    System.out.println("Failed in >> " + val);
                    return false;
                }
            }
        }

        if(row > 0 && col > 0){
            for( int i = row-1,j = col-1; i >= 0 && j >= 0 ; i--,j-- ) {
                if(arr[i][j] == 1) {
                    val = 3;
                    System.out.println("Failed in >> " + val);
                    return false;
                }
            }
        }

        if(row > 0 && col < arr.length -1){
            for( int i = row-1 , j = col+1; i > 0&& j < arr.length-1 ; i--,j++ ) {
                if(arr[i][j] == 1) {
                    val = 4;
                    System.out.println("Failed in >> " + val + ":"+ arr[i][col+1]);
                    return false;
                }
            }
        }
        return true;
    }

    public static void print(int [][] arr) {

        for( int i = 0 ; i < arr.length; i++) {
            for(int j = 0 ; j < arr.length; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }


}
