package com.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class UniqueIntegersAfterKRemovals {

    public static void main(String[] args) {

//        int [] arr =  new int [] {4,3,1,1,3,3,2};
//        int k = 3;

        int [] arr =  new int [] {5,5,4};
        int k = 1;

        findLeastNumOfUniqueInts(arr,k);



    }

    public static int findLeastNumOfUniqueInts(int [] arr, int k ) {

        PriorityQueue<Integer> queue = new PriorityQueue();
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i],1);
            } else {
                int value = map.get(arr[i]);
                map.put(arr[i],(value+1));
            }
        }
        System.out.println(map);
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            queue.add(entry.getValue());
        }
        System.out.println(queue);

        while(k > 0) {
            Integer val = queue.peek();
            if(val > 1) {
                val = val-1;
                System.out.println("reducing the element " + queue.peek() + " , " + val);
                queue.remove();
                queue.add(val);
            } else {
                queue.remove();
            }

            k--;
        }
        System.out.println(queue);

        return queue.size();
    }
}
