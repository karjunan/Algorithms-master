package com.algorithms.arrayproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class KDiffPair {

    public static void main(String[] args) {

        int [] arr = {3, 1, 4, 1, 5};
        int  k = 2;
        int result = kDiffPairs(arr,k);
        System.out.println(" Result >> " + result);

    }

    public static int kDiffPairs(int [] arr, int k ) {

        if(k < 0) {
            return 0;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for( int i = 0 ; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        HashSet<List<Integer>> set = new HashSet<>();
        for( int i = 0 ; i < arr.length; i++) {
            int val = arr[i] + k;
            List<Integer> list = new ArrayList<>();
            if(map.containsKey(val) && map.get(val) != i ) {
                list.add(val);
                list.add(arr[i]);
                set.add(list);
            }
        }
        return set.size();

    }


}
