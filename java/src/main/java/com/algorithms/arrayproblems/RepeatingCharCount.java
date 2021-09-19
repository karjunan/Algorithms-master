package com.algorithms.arrayproblems;

public class RepeatingCharCount {


    public static void main(String[] args) {


        String str = "aaabbbc";

        // boolean bool = allUnique(str);

        String str1 = repeating(str);

        System.out.println("New string >>" + str1);

    }

    public static String repeating(String str) {

        int i = 0;
        int j = 1;
        int count = 1;
        StringBuffer buffer = new StringBuffer();
        while( j <= str.length() ) {

            if( j == str.length() ) {
                buffer.append(str.charAt(i));
                buffer.append((j-i));
                break;
            }

            if(str.charAt(i) == str.charAt(j)) {
                count++;
            } else {
                buffer.append(str.charAt(i));
                buffer.append(count);
                count = 1;
                i = j;
            }
            j++;
        }

        return buffer.toString();
    }

}
