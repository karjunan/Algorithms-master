package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllSubSets {

    public static void main(String [] args ) {

        int [] arr = {1,2,3,4};

        findAllSubSets(arr);

    }

    public static void findAllSubSets(int[] arr) {

        LinkedList<Integer> in = Arrays.stream(arr).mapToObj(v -> Integer.valueOf(v)).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> out = new LinkedList<>();
        List<LinkedList<Integer>> fList = new ArrayList<>();

        findAllSubSets(in,out,fList);

    }

    public static void findAllSubSets(LinkedList<Integer> in, LinkedList<Integer> out, List<LinkedList<Integer>> fList) {

        // System.out.println(out);

        if(in.isEmpty()) {
            LinkedList<Integer> l = new LinkedList<>();
            l.addAll(out);
            out = l;
            fList.add(l);
            System.out.println(fList);
            return;
        }

        int val = in.removeFirst();
        out.addLast(val);
        findAllSubSets(in,out,fList);
        int v = out.removeLast();
        findAllSubSets(in,out,fList);
        in.addLast(v);


    }


}
