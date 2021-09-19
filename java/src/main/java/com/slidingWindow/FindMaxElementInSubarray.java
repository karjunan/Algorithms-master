package com.slidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FindMaxElementInSubarray {

    public static void main(String[] args) {
        int [] arr = new int[] {1,2,3,1,4,5,2,3,6};
        int k = 3;
        System.out.println(maxElementInSubArray(arr,k));
    }

    public static List<Integer> maxElementInSubArray(int [] arr, int k) {
        List<Integer> list = new ArrayList<>();
        int windowStart = 0 ;
        Deque<Integer> deque = new LinkedList<>();
        int windowEnd = 0;
        for(;windowEnd < k; windowEnd++) {
            // check the first window and add index which are useful
            while(!deque.isEmpty() && arr[windowEnd] > arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(windowEnd);
        }
        System.out.println(deque);
        for(;windowEnd < arr.length; windowEnd++) {
            list.add(arr[deque.peekFirst()]);
            System.out.println("Elements inside list => " + list);
//            1,2,3,1,4,5,2,3,6
              // 3
            //Remove the index which are out of bound from current k
            while(!deque.isEmpty() && deque.peekFirst() <= windowEnd-k) {
                deque.removeFirst();
            }
            System.out.println("elements removed " + deque);
            //Remove useless element which might be of no use to be in the queue
            while(deque.isEmpty() && arr[deque.peekLast()] <  arr[windowEnd]) {
                deque.removeLast();
            }
            System.out.println("Removed useless elements => " + deque);
            deque.addLast(windowEnd);
        }
        return list;
    }

}
