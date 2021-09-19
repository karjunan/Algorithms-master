package com.algorithms.algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TopologicalSort {


    public static void main(String [] args) {

        int [] arr = {1,2,3,4};
        ArrayList<Integer> jobs = Arrays.stream(arr).mapToObj(v -> Integer.valueOf(v)).collect(Collectors.toCollection(ArrayList::new));

        System.out.println(jobs);

        ArrayList<Integer> result = topologicalSort(jobs,buildDep());
        System.out.println(result);
    }

    public static ArrayList<Integer> topologicalSort(ArrayList<Integer> jobs,ArrayList<Integer[]> deps) {


        return null;
    }

    public static ArrayList<Integer[]> buildDep() {
        ArrayList<Integer[]> list = new ArrayList<>();

        Integer [] dep1 = new Integer[2];
        dep1[0] = 1;
        dep1[1] = 2;

        Integer [] dep2 = new Integer[2];
        dep1[0] = 1;
        dep1[1] = 3;

        Integer [] dep3 = new Integer[2];
        dep1[0] = 3;
        dep1[1] = 2;

        Integer [] dep4 = new Integer[2];
        dep1[0] = 4;
        dep1[1] = 2;

        Integer [] dep5 = new Integer[2];
        dep1[0] = 4;
        dep1[1] = 3;

        list.add(dep1);
        list.add(dep2);
        list.add(dep3);
        list.add(dep4);
        list.add(dep5);
        return list;

    }
}
