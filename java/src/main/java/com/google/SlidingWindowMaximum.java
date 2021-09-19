package com.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        int [] nums = new int []{1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow(nums,k);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < k; i++) {
            queue.add(nums[i]);
        }
        list.add(queue.peek());

        for( int i = k; i < nums.length; i++) {
            queue.remove(nums[i-k]);
            queue.add(nums[i]);
            list.add(queue.peek());
             System.out.println("queue => " + queue);
             System.out.println("list => " + list);
        }
        // int [] result = new int[list.size()];

        return  list.stream().mapToInt(x -> x).toArray();
    }
}
