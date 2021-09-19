package com.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

//  19.0.1.24 - loggin as name , at [12,42]

public class SubArrayProblem {

    public static void main(String [] args) {

        Stack<Integer> list = new Stack<Integer>();
        list.add(11);
        list.add(24);
        list.add(13);
        list.add(21);


        Queue<Integer> out = new LinkedBlockingQueue<Integer>();
        List<Queue<Integer>> ls = new ArrayList<Queue<Integer>>();
        subArray(list,out,21);

    }

    public static void subArray( Stack<Integer> list,Queue<Integer> out,int var) {

        if(list.isEmpty()) {
            System.out.println(out);
            if(out.stream().mapToInt(v -> v.intValue()).sum() == var ) {
                System.out.println("Match found :: >>>>>>>>>> " + out);
            }
            // .forEach(System.out::println);
        } else {

            Integer val = list.pop();
            subArray(list,out,var);
            out.add(val);
            subArray(list,out,var);
            list.add(out.poll());
        }
    }


}
