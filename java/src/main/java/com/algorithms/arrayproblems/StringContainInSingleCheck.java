package com.algorithms.arrayproblems;

public class StringContainInSingleCheck {


    public static void main(String[] args) {


        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        boolean result = validate(s1,s2);
        System.out.println("Result >> " + result);

    }

    public static boolean validate(String s1, String s2) {
        String s11 = "";
        if(s1.length() == s2.length() && s1.length() > 0) {
            s11 = s1 + s1;
        }
        return s11.contains(s2);

    }

}
