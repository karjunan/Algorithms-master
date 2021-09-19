package com.afterlongpractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Combinations {

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3};

        List<Integer> list = Arrays.stream(arr).mapToObj(v -> Integer.valueOf(v)).collect(Collectors.toList());

//        combinations(list,new ArrayList<>());
        List<List<Integer>> result = new ArrayList<>();
        comb(list,0,new ArrayList<>(),result);
        System.out.println(result);
    }

    public static void comb(List<Integer> input,int startIdx, List<Integer> output, List<List<Integer>> result) {
        result.add(new ArrayList<>(output));
        //System.out.println(startIdx + " :: " + output);
        int i = startIdx;
        System.out.println(i + " ::: " + startIdx);
        for(; i < input.size(); i++) {
            System.out.println("Values inside loop => " + i + " :: " + startIdx);
            output.add(input.get(i));
            comb(input,i+1, output,result);
            output.remove(output.size()-1);

        }

    }

    public static void combinations( List<Integer> list, List<Integer>  output) {
        System.out.println(list + " >>>> " + output );
        if(list.isEmpty()) {
            //System.out.println(output);
            return;
        }

        Integer val = list.remove(0);
        output.add(val);
        combinations(list,output);
        output.remove(output.size()-1);
        combinations(list,output);
        list.add(val);


    }



}
