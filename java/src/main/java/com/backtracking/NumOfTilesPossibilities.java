package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class NumOfTilesPossibilities {

    public static void main(String[] args) {
        NumOfTilesPossibilities num = new NumOfTilesPossibilities();
        int size = num.numTilePossibilities("Hello");
        System.out.println("Size is "+ size);
    }
    public int numTilePossibilities(String tiles) {
        List<String> input = new CopyOnWriteArrayList<>();
        String [] s = tiles.split("");
        for(String i: s) {
            input.add(i);
        }
        System.out.println("Input is " + input);
        ArrayList<ArrayList<String>> finalList = new ArrayList<>();
        helper(input,new ArrayList<>(),input.size(),finalList);
        return finalList.stream().flatMap(v -> v.stream()).collect(Collectors.toList()).size();
    }

    public void helper(List<String> input, ArrayList<String> output, int size, ArrayList<ArrayList<String>> finalList) {
        System.out.println(output);
        if(output.size() == size) {
            finalList.add(new ArrayList<String>(output));
        }
        for(int i = 0 ; i < input.size(); i++) {
            String ch = input.remove(i);
            output.add(ch);
            helper(input,output,size+1,finalList);
            output.remove(output.size()-1);
            input.add(ch);
        }
    }
}
