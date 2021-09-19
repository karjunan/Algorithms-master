package com.google;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int [] nums = new int [] {1,3,-1,-3,5,3,6,7};
                                //0,1,2,3,4,5,6,7,8
        int k = 3;
        maxSlidingWindow(nums,k);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // Finding the largest elements among first k elements
        for(int i = 0 ; i < k; i++) {
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);

        }
        list.add(nums[deque.peekFirst()]);
        for(int i = k ; i < nums.length; i++) {
            System.out.println("Current Element worked on is => " + nums[i]);

            // 1. Remove the element which is out of the window size
            while(!deque.isEmpty() && deque.peekFirst() == i-k) {
                deque.removeFirst();
            }
//            System.out.println("After removing out of range index => " + deque);
            // 2. Remove the elements which are not useful
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
//            System.out.println("After removing unused elements => " + deque);
            deque.addLast(i);
            list.add(nums[deque.peekFirst()]);
            System.out.println(list);

        }
        return null;
    }
}
