package com.afterlongpractise;

public class PrintBinary {

    public static void main(String[] args) {
        bin(43);
    }

    public static void bin(int num) {
        if(num < 2) {
            System.out.print(num);
        } else {
            int lastDigit = num % 2;
            int restOfTheDigit = num / 2;
            bin(restOfTheDigit);
            System.out.print(lastDigit);
        }
    }

}
