package com.java8;

public class OnlyContainStrings {

    public static void main(String[] args) {

        String str = "GeekGeeks";
        boolean bool = str.chars().allMatch(Character::isLetter);
        System.out.println(bool);

    }
}
