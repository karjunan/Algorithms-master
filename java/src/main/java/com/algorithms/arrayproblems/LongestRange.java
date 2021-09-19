package com.algorithms.arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongestRange {


    public static void main(String [] args) {

        int [] arr = {1,11,3,0,15,5,2,4,10,7,12,6};

        int [] res = longestRange(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int [] longestRange( int [] arr ) {

        Map<Integer,Boolean> map = new HashMap<>();
        for( int i = 0 ; i < arr.length; i++) {
            map.put(arr[i],false);
        }

        System.out.println(map);

        int i = 0;
        int prevVal = Integer.MIN_VALUE;
        int nextVal = Integer.MAX_VALUE;
        LinkedList<Integer> list = null;
        int [] result = new int[2];
        ArrayList<LinkedList<Integer>> fs = new ArrayList<>();
        while( i < arr.length) {
            list =  new LinkedList<>();
            list.add(arr[i]);
            prevVal = arr[i];
            nextVal = arr[i];
            while(true) {
                prevVal--;
                if(!map.containsKey(prevVal)) {
                    break;
                }
                if(map.get(prevVal) == true) {
                    break;
                }
                list.addFirst(prevVal);
                map.put(prevVal, true);
            }

            while(true) {
                nextVal++;
                if(!map.containsKey(nextVal)) {
                    break;
                }
                if(map.get(nextVal) == true) {
                    break;
                }
                list.addLast(nextVal);
                map.put(nextVal,true);
            }
            if(fs.isEmpty() && !list.isEmpty()) {
                fs.add(list);
            } else if(!list.isEmpty() && list.size() > fs.get(0).size())       {
                fs.remove(0);
                fs.add(list);

            }
            i++;

        }
        if(!fs.isEmpty()) {
            List<Integer> ls = fs.get(0);
            result[0] = ls.get(0);
            result[1] = ls.get(ls.size()-1);

        }
        return result;

    }

}
