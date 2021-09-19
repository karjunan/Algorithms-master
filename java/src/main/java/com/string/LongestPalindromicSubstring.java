package com.string;

public class LongestPalindromicSubstring {

    // static String s = "abaxyzzyxf";
    static String s  = "xyzzyxabcddcba";
    public static void main(String[] args) {

        String result =  longestPalindromeSubstring(s);

        System.out.println("Result -> " + result);
    }

    public static String longestPalindromeSubstring(String str) {

        if(str.length() == 1) {
            return str;
        }
        String result = "";
        for( int i = 1 ; i < str.length(); i++) {

            String bufferOdd = isPalindrome(str,i-1,i+1);
            String bufferEven = isPalindrome(str,i-1,i);

            if(bufferOdd.length() > bufferEven.length() && bufferOdd.length() > result.length()) {
                result = bufferOdd;
            } else if (bufferOdd.length() < bufferEven.length() && bufferEven.length() > result.length()) {
                result = bufferEven;
            }

        }
        return result;
    }

    public static String isPalindrome(String str,int j, int k) {
        StringBuffer buffer = new StringBuffer();
        while(j >= 0 && k < str.length()) {

            if(str.charAt(j) == str.charAt(k)) {
                buffer.append(str.charAt(j));
                buffer.append(str.charAt(k));
                j--;
                k++;
                System.out.println(buffer.toString());
            } else {
                buffer = new StringBuffer();
                break;
            }
        }
        return str.substring(j+1,k);
    }



}
