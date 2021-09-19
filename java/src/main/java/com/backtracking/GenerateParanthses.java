package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthses {

    public static void main(String[] args) {

        int nums = 3;
        List<String> result = new ArrayList();
        helper(result,"",nums,nums);
        System.out.println(result);        

    }

    public static void helper(List<String> result, String cur, int left, int right) {
        if(left < 0 || left > right) {
            return;
        }
        
        if(left == 0 && right == 0) {
            System.out.println(cur);
            result.add(cur);
        }

        helper(result,cur + "(", left - 1, right);
        helper(result,cur + ")", left, right - 1);
    }
    
}
