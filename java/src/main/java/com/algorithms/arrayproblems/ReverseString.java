package com.algorithms.arrayproblems;


class ReverseString {

    static String str = "krishna";
    public static void main(String [] ar) {

        System.out.println(reverse(str));

    }

    public static String reverse(String str) {
        char [] ch = new char[str.length()];
        int count = str.length()-1;
        for( int i = 0; i < str.length(); i++ ) {
            ch[count] = str.charAt(i);
            ch[i] = str.charAt(count);
            count--;
        }
        return new String(ch);
    }

}