package com.practise2;

public class MaximumSumContigousSubarrayRecurssive {

    public static void main(String[] args) {

//        int [] arr = {-2,-3,4,-1,-2,1,5,-3};
        int [] arr = {-2, -5, -6, -2, -3, -1, -5, -6};
        int result = recurssiveSubarray(arr,0,arr.length-1);
        System.out.println("The max subArray is =>  " + result);

    }

    public static int recurssiveSubarray(int [] arr,int left, int right) {

        if(left == right) {
            return arr[left];
        }
        int mid = (left + right) / 2;
        int leftSum = recurssiveSubarray(arr,left,mid);
        int rightSum = recurssiveSubarray(arr,mid+1,right);

        int sum = 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        for(int i = 0; i <= mid; i++) {
            sum = sum + arr[i];
            leftMax = Math.max(leftMax,sum);
        }

        sum = 0;
        for(int i = mid+1; i < arr.length; i++) {
            sum = sum + arr[i];
            rightMax = Math.max(rightMax,sum);
        }

        int result = Math.max(leftMax+rightMax,Math.max(leftMax,rightMax));
        int finalResult = Math.max(result,Math.max(leftSum,rightSum));

        return finalResult;
    }
}
