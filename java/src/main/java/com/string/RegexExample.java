package com.string;

import java.util.Arrays;

public class RegexExample {

    public static void main(String[] args) {
        String str = "This,  is ,  a , good, Quote";

        str.matches("\\W");
        System.out.println(str);
        System.out.println(Arrays.asList(str.split(",")));
        boolean bool = str.matches("b.d.f");
        System.out.println(bool);
    }


}
