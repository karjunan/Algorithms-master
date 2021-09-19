package com.google;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfSubSets {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        int val = 5;
        for(int i = 0 ; i < 5; i++) {
             val = ((val * 8) % 11);
            list.add(val);
        }
        System.out.println("Input List => " + list);
        List<List<Integer>> ls = new ArrayList<>();
        sumOfSubSets( list, 10,0, new ArrayList<>());
    }

    public static void sumOfSubSets(List<Integer> input, int sum,
                                    int left,List<Integer> list  ) {
//        System.out.println("Left pointer => " + left + " ::  " + sum);
        if(sum == 0) {
            System.out.println("Reached Sum Finally => " + sum + " : " + list);
            return;
        }

        if(left >= input.size() || sum < 0) {
//            System.out.println("Sum is greater or reached the end of the list");
            return;
        }

        int val = input.get(left);
        if(sum -input.get(left) < 0) {
            list.add(val);
        }
        sumOfSubSets(input,sum-input.get(left),left+1,list);
        list.remove(new Integer(val));
        sumOfSubSets(input,sum,left+1,list);
    }
}
