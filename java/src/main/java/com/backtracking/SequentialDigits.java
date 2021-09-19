package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {


    public static void main(String[] args) {
        int low = 58;
        int high = 155;
        List<Integer> list = sequentialDigits(low, high);
        System.out.println(list); 
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> list = new ArrayList<>();
        String str = "123456789";
        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();

        for(int i = lowLength; i <= highLength; i++) {
            for(int j = 0; j <= str.length()-i; j++) {
                int num = Integer.valueOf(str.substring(j, (j+i)));
                System.out.println(num);
                if(num >= low && num <= high) {
                    list.add(num);
                    System.out.println(list);
                } else if(num > high) {
                    break;
                }
            }
        }
        return list;
    }
    
}
