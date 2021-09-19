package com.algorithms.recursion;

public class BinaryToDecimalRecursive {
    public static void main(String [] args) {

        String str = "1111";

        int val = binaryToDecimalRecursive(str,str.length()-1);
        System.out.println("Decimal Value -> " + val);
    }

    public static int binaryToDecimalRecursive(String str, int n) {

        if(n == 0 ) {
            return 1 * Integer.valueOf(Character.toString(str.charAt(n))) ;
        }

        int result = binaryToDecimalRecursive(str,n-1);
        String value = Character.toString(str.charAt(n));
        int val = Integer.valueOf(value);
        Double d = Math.pow(2,n);
        result = result + (val * d.intValue());
        return result;
    }
}
