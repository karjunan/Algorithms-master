package com.afterlongpractise;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public static void main(String[] args) {
        int n = 2;
        List<String> result = new ArrayList<>();
        helper(n,n,"",result);
    }

    public static void intend(int size) {
        for (int i = 0 ; i < size; i++) {
            System.out.print("  ");
        }
    }
    public static void helper(int left, int right, String output, List<String> result) {
        intend(output.length());
        System.out.println(output);
        if(left < 0 || left > right) {
            return;
        }

        if(left == 0 && right == 0) {
            System.out.println(output);
            result.add(output);
            return;
        }

        helper(left -1 , right, output+"(",result);
        helper(left , right-1, output+")",result);

    }

}
