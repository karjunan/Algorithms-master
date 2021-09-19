package com.afterlongpractise;

public class TowerOfHanoie {

    public static void main(String[] args) {
        toh(3,1,2,3);
    }

    public static void toh(int noOfDisks, int a, int b, int c) {
        if(noOfDisks > 0) {
            toh(noOfDisks-1, a,c,b);
            System.out.println("Move disks from "+ a + " : "+ c);
            toh(noOfDisks-1, b,a,c);
        }
    }
}
