package com.google;

public class RepeatingNumberExceptOne {


    public static void main(String[] args) {
        int [] arr = new int[] {1,2,3,2,1,5,6,7,7,6,5,3,87,68};
        int value = arr[0];
        for(int i = 1 ; i < arr.length; i++) {
            value = value ^ arr[i];
        }

        System.out.println(value);
    }
}
