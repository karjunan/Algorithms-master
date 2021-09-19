package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SubSetSum {

    public static void main(String [] args ) {

        int arr[] = {15, 22, 14, 26, 32, 9, 16, 8};

        int target = 53;

        LinkedList<Integer> list = Arrays.stream(arr).mapToObj(v -> Integer.valueOf(v)).collect(Collectors.toCollection(LinkedList::new));

        // System.out.println(list);

         subSetSum(list,new LinkedList<Integer> (), target);
//        subSetSumNew(arr,target,0,new LinkedList<>(), new ArrayList<>());
    }

    public static void subSetSumNew(int[] arr, int sum,int i, LinkedList<Integer> sol,List<LinkedList<Integer>> fList) {
        // System.out.println(" Sol >> " + sol + " >> " + sum);
        if(sum < 0) {
            return;
        }

        if(sum == 0) {
            fList.add(sol);
            LinkedList<Integer> ls = new LinkedList<>();
            ls.addAll(sol);
            sol = ls;
            System.out.println("Result >> " + fList );
        }

        if( i >= arr.length) {
            return;
        }

        sol.add(arr[i]);
        subSetSumNew(arr,sum - arr[i], i + 1, sol,fList);
        sol.removeLast();
        subSetSumNew(arr,sum ,i + 1, sol,fList);
    }



    public static void subSetSum(LinkedList<Integer> list,LinkedList<Integer> out, int sum) {
        // System.out.println(out);
        int result = out.stream().mapToInt(v->v.intValue()).sum();
        if(result > sum ) {
            return;
        }

        if(result == sum ) {
            System.out.println(out + " : >> " + result );
            return;
        }

        for(int i = 0 ; i < list.size(); i++ ) {
            out.add(list.removeFirst());
            subSetSum(list,out,sum);
            list.addLast(out.removeLast());
        }


    }
}
