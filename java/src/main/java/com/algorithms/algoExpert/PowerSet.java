package com.algorithms.algoExpert;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String [] args) {
        List<Integer> arr = List.of(1,2,3);
        ArrayList<Integer> newList = new ArrayList<Integer>(arr);
        ArrayList<ArrayList<Integer>> ls = subset(newList);
        System.out.println(ls);

    }

    public static ArrayList<ArrayList<Integer>> subset(ArrayList<Integer> array) {


        int i = 0 ;
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        ls.add(first);
        while(i < array.size()) {
            int val = array.get(i);

            int k = 0;
            int index = ls.size();
            System.out.println("Index length -> " + index);
            while( k < ls.size() && k < index) {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.addAll(ls.get(k));
                newList.add(val);
                ls.add(newList);
                k++;
                System.out.println(ls);
            }
            i++;
        }

        return ls;
    }


}
