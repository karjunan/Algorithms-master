package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LongestSubarrayAfterDeletingOneElement {

    public static void main(String[] args) {

        int [] nums = new int[] {0,1,1,1,0,1,1,0,1};


    }

    public int longestSubarray(int[] nums) {

        int i = 0;
        int j = 0;

        while(i < nums.length) {
            if(nums[i] != 0) {
                i++;
            } else {
                j = i;
            }
        }

        return 0;
    }



}
