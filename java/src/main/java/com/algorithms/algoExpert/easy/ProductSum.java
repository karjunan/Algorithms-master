package com.algorithms.algoExpert.easy;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {

      public static void main(String[] args) {
            List<Object> input = new ArrayList<>();
            input.add(5);
            input.add(2);
            List<Object> list1 = new ArrayList<>();
            list1.add(7);
            list1.add(-1);
            input.add(list1);
            input.add(3);
            List<Object> list3 = new ArrayList<>();
            list3.add(6);
            List<Object> list4 = new ArrayList<>();
            list4.add(-13);
            list4.add(8);
            list3.add(list4);
            list3.add(4);
            input.add(list3);
            System.out.println(input);
            int result = productSum(input,1);
            System.out.println("Final Output is =>  " + result);
      }

      public static Integer productSum(List<Object> list,int depth) {
            int sum = 0;
            for(Object input: list) {
                  if(input instanceof List) {
                        sum += productSum((List<Object>) input, depth+1);
                        System.out.println("Sum is  => " + sum );
                  } else {
                        sum += (Integer) input;
                        System.out.println("Building Target when not in recurssion =>> " + sum);
                  }

            }
            System.out.println(list + ":: " + depth + " :: " + sum );
            return (sum*depth);
      }
}
