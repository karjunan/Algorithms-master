package com.afterlongpractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) {
        int [] val = new int[]{1,2,3};
        List<Integer> input = Arrays.stream(val).mapToObj(v -> Integer.valueOf(v)).collect(Collectors.toList());
//        perm(val,0);
        perm1(input,new ArrayList<>());
    }

    public static void indent(int size) {
        for(int i = 0; i < size; i++) {
            System.out.print("   ");
        }
    }
    public static void perm1(List<Integer> input , List<Integer> output) {
        indent(output.size());
        System.out.println(output);
        if(input.isEmpty()) {
            System.out.println(output);
        }
        for(int i = 0 ; i < input.size(); i++) {
            int val = input.remove(i);
            output.add(val);
            perm1(input,output);
            input.add(i,val);
            output.remove(output.size()-1);
        }
    }

    public static void perm(int [] val, int idx) {
        indent(idx);
        System.out.println(Arrays.toString(val));
        if(idx == val.length) {
      //      System.out.println(Arrays.toString(val));
            return;
        }
        for(int i = idx; i < val.length; i++) {
            swap(i,idx,val);
            perm(val,idx+1);
            swap(i,idx,val);
        }
    }

    public static void swap(int i, int j, int [] val) {
        int temp = val[i];
        val[i] = val[j];
        val[j] = temp;
    }
}
