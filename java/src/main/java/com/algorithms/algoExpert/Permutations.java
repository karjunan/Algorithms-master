package com.algorithms.algoExpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {


    public static void main(String [] args) {

        List<Integer> list = List.of(1,2,3);
        perm(new ArrayList<Integer>(list));
    }


    public static ArrayList<ArrayList<Integer>> perm(ArrayList<Integer> array ) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        helper(0,array,list);
        return list;
    }

    public static void helper(int i, ArrayList<Integer> array,ArrayList<ArrayList<Integer>> finalList) {
        System.out.println(array + " >>>>>> " + i);
        if(i == array.size()) {
            ArrayList<Integer> ls = new ArrayList<Integer>(array);
            finalList.add(ls);
//            System.out.println(finalList);
            return;
        }

        for( int j = i ; j < array.size(); j++) {
//            System.out.println("i ->> " + i + " ::  j ->>  " + j  );
            Collections.swap(array,i,j);
            helper(i+1,array,finalList);
            Collections.swap(array,i,j);
        }

    }

}
