package com.afterlongpractise;

import java.util.ArrayList;
import java.util.List;

public class FindFileExpansion {

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("pattern");
        input.add("matcher");
        input.add("it");
        input.add("map");
        input.add("newWord");
        input.add("notGone");
        input.add("it");
        input.add("map");

        print(input,2, "it");


    }

    public static void print(List<String> input, int context, String it) {
        List<String> output = new ArrayList<>();
        for(int i =0 ; i < input.size(); i++) {

            if(input.get(i).equals(it)) {
                int left = i - context;
                int right= i + context;
                while(left >= 0 && left < i) {
                    output.add(input.get(left));
                    left++;
                }
                output.add(input.get(i));
                while(right < input.size() && right >= i) {
                    output.add(input.get(right));
                    right--;
                }
                i = right+1;
            }
            System.out.println(output);
        }


    }


}
