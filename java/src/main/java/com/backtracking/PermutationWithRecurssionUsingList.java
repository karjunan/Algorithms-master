package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class PermutationWithRecurssionUsingList {

    public static void main(String [] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        List<Integer> out = new ArrayList<Integer>();
        List<Queue<Integer>> ls = new ArrayList<Queue<Integer>>();
        subArray(list,out);
        int [] arr = {1,2,3};
        Arrays.asList(arr);

    }

    public static void subArray( List<Integer> list, List<Integer> out) {

        if(list.isEmpty()) {
            System.out.println(out);
        } else {

            for(int i = 0 ; i < list.size(); i++ ) {

                //choose
                int val = list.remove(i);
                out.add(val);

                //explore
                subArray(list,out);

                //unchoose
                list.add(i,out.get(out.size()-1));
                out.remove(out.get(out.size()-1));

            }
        }
    }

}
