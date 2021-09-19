package com.test.emp;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        int i = 0;
        while( i < 10) {
            int val = (int)(1+ Math.random() * (10 - (i + 1)));
            System.out.println(val);
            i++;
        }
    }
}
