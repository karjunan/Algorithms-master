package com.google;

public class LongestRepeatedSubstring {

    public static void main(String[] args) {
        String str = "krisaaasshnakumar";
        System.out.println("=>    " + str);
        lrs(str,0,0);
    }

    public static void lrs(String str, int i, int j) {
        if(j >= str.length() || i >= str.length()) {
            return;
        }

        if(str.charAt(i) == str.charAt(j)) {
            char [] ch = str.toCharArray();
            if(j-i >= 1) {
                for(int k = i; k <= j ; k++) {
                    System.out.print(str.charAt(k));
                }
            }

            System.out.println("\n");
//            String subString = str.substring(i,j);
//            System.out.println("SubString is => " + new String(ch));
            lrs(str,i,j+1);
        } else {
            lrs(str,i+1,j);

        }




    }
}
