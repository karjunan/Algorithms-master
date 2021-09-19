package com.string;

public class ShiftString {

    static String A = "abcde";
    static String B = "cdeab";

    public static void main(String [] args) {

        System.out.println("Is possible= " + shift(A,B));
    }

    public static boolean shift(String a, String b) {
        char [] ch = a.toCharArray();

        if(a.equals(b)) {
            return true;
        }

        int i = 0;
        while(i < a.length()) {
            char temp = ch[0];
            int j = 0;
            while( j < a.length() -1 ) {
                ch[j] = ch[j+1];
                j++;
            }
            ch[ch.length-1] = temp;
            if(new String(ch).equals(b)) {
                return true;
            }
            i++;
        }
        return false;

    }

}
