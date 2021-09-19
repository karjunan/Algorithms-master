package com.afterlongpractise;

import java.util.ArrayList;
import java.util.List;

public class Combinations1 {

    public static void main(String[] args) {

        int [] val = new int[]{1,2,3,4};
        comb(val,0, new ArrayList<>());
    }

    public static void indent(int size) {
        for(int i = 0 ; i < size;i++) {
            System.out.print("   ");
        }
    }
    public static void comb(int[] val, int idx, List<Integer> output) {
        indent(output.size());
        System.out.println(output);

        for(int i = idx; i < val.length; i++) {
            output.add(val[i]);
            comb(val,i+1,output);
            output.remove(output.size()-1);
        }
    }
}
