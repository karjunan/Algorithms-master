package com.backtracking;

public class PrintBinary {

    public static void main(String [] args) {

        printBinary(3,"");

    }

    public static void printBinary(int digits,String prefix) {
//        System.out.println("Digits : " + digits + "  -- [" +prefix+"]" );
        if(digits == 0 ) {
            System.out.println(prefix);
            return;
        }
        else {
            printBinary(digits-1, prefix+"0");
            printBinary(digits-1, prefix+"1");
        }

    }

}
