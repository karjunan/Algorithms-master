package com.afterlongpractise;

import java.util.Arrays;
import java.util.Stack;

public class NSE {

    public static void main(String[] args) {
        int [] arr = new int[] { 1, 3, 3, 2, 4, 1, 5, 3, 2};

        int [] leftSmall = new int[arr.length];
        int [] rightSmall = new int[arr.length];

        for(int i = 0 ; i < arr.length; i++) {
            leftSmall[i] = i;
            rightSmall[i] = i;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++) {

            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                    int index = stack.pop();
                    leftSmall[index] = i;
            }
            stack.push(i);
        }

        for(int i = arr.length-1; i >= 0; i--) {

            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                int index = stack.pop();
                rightSmall[index] = i;
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(leftSmall));
        System.out.println(Arrays.toString(rightSmall));

    }

}
