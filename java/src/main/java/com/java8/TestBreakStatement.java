package com.java8;

public class TestBreakStatement {

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {

            for(int j = 0; j < 10; j++) {
                if(j == 2) {
                    System.out.println(" Broke J  " + j);
                    break;
                }
            }
            System.out.println(" Not broken   " + i);
            for(int k = 0; k < 10; k++) {
                if(k == 2) {
                    System.out.println(" Broken  K " + k);
                    break;
                }
            }

            System.out.println("end of i " + i);
        }
    }
}
