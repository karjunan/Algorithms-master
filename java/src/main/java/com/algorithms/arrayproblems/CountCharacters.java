package com.algorithms.arrayproblems;

public class CountCharacters {


    static String str = "aabbcdd";


    public static void main(String [] ar) {

        String result = count(str);
        System.out.println("Final Output >> " + result);
    }

    public static String count(String str) {

        int i = 0;
        int j = 1;
        StringBuffer buffer = new StringBuffer();
        if(str.length() == 1) {
            buffer.append(str.charAt(i));
            buffer.append(1);
            return buffer.toString();
        }
        while( i < j && j < str.length()) {

            while(j < str.length() && str.charAt(i) == str.charAt(j)) {
                j++;
            }
            buffer.append(str.charAt(i));
            buffer.append(j-i);
            System.out.println(buffer.toString());
            i = j;
            j = j + 1;
        }

        if(i < str.length() &&  str.charAt(i-1) != str.charAt(j-1)) {
            buffer.append(str.charAt(i));
            buffer.append(1);
        }
        System.out.println(buffer.toString());
        return buffer.toString();
    }
}
