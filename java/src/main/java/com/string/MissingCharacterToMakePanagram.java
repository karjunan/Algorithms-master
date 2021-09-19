package com.string;

public class MissingCharacterToMakePanagram {

     static String str = "welcome to geeksforgeeks";
//    static String str = "The quick brown fox jumps";
    public static void main(String [] args) {

        String result = missingCharacter(str);
        System.out.println("Missing Characters -> " + result);

    }

    public static String missingCharacter(String str) {

        boolean[] bool = new boolean[26];


        for( int i = 0 ; i < str.length(); i++) {
            if(str.charAt(i) == ' ')
                continue;

            if(str.charAt(i) < 'a') {
                int result = (int)str.charAt(i) + 32;
                bool[result-97] = true;
                continue;
            }

            int position = str.charAt(i) - (int)'a';
            bool[position] = true;
        }

        StringBuffer buffer = new StringBuffer();
        for( int i = 0 ; i < bool.length; i++) {
            if(bool[i] == false) {
                int result = i + 97;
                buffer.append((char)result);
            }
        }

        return buffer.toString();
    }

}
