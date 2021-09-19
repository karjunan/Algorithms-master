package com.google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
       int [] input = {1,2,3};
       List<Integer> ls = new ArrayList<>();
       ls.add(1);
       ls.add(2);
       ls.add(3);

        LinkedList<Integer> output = new LinkedList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        helper(0,input,output,finalList);
//        helper1(0,ls,finalList,output);
    }

    public static void helper1(int pos, List<Integer> input, List<List<Integer>> list,
                               List<Integer> output) {

        if(pos == input.size() )  {
            list.add(new ArrayList(output));
            System.out.println(list);
            return;
        }

       int val = input.get(pos);
       output.add(val);
       helper1(pos+1, input,list,output);
       output.remove(output.size()-1);
       helper1(pos+1,input,list,output);
    }

    public static void helper(int num, int [] input,LinkedList<Integer> output,
                              List<List<Integer>> finalList) {
        finalList.add(new ArrayList<>(output));
        System.out.println(finalList);
        for(int i = num; i < input.length; i++) {
            output.addLast(input[i]);
            helper(i+1,input,output,finalList);
//            output.remove(output.size()-1);
            output.removeLast();
//            input.removeFirst();
        }

    }
}
