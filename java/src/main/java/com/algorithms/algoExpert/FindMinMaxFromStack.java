package com.algorithms.algoExpert;

import java.util.Arrays;
import java.util.Random;

public class FindMinMaxFromStack {

    static int [] arr = new int [10];
    static int [] maxArr = new int[arr.length];
    static int [] minArr = new int[arr.length];
    static Random random = new Random();
    static int top = -1;
    static int min = -1;
    static int max = -1;

    public static void main(String[] args) throws Exception{

        for( int i = 0 ; i < 10; i++) {

            push(random.nextInt(50));
            // push(i);
        }

        System.out.println("Data now is -> " + peek());
        System.out.println(Arrays.toString(arr));
        System.out.println("Max Array -> " + Arrays.toString(maxArr));
        System.out.println("Min Array -> " + Arrays.toString(minArr));
        for(int i = 0 ; i < 5 ; i++) {
            pop();
            System.out.println("Min and Max is -> " + min() + " -- " + max());

        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Data now is -> " + peek());
        System.out.println("Min and Max is -> " + min() + " -- " + max());
    }

    public static void push(int data) throws Exception{
        if( top > arr.length )  {
            throw new Exception("Stack is full");
        }
        arr[++top] = data;


        if(min < 0 && max < 0) {
            minArr[++min] = data;
            maxArr[++max] = data;
            return;
        }

        if(data < minArr[min] && min < minArr.length) {
            minArr[++min] = data;
        } else if(min < minArr.length && min > 0 && data < minArr[min]) {
            int temp = minArr[min-1];
            minArr[++min] = temp;
        } else {
            int temp = minArr[min];
            minArr[++min] = temp;
        }

        if(data > maxArr[max] && max < maxArr.length) {
            maxArr[++max] = data;
        } else if(max < maxArr.length && max > 0 && data > maxArr[max]) {
            int temp = maxArr[max-1];
            maxArr[++max] = temp;
        } else {
            int temp = maxArr[max];
            maxArr[++max] = temp;
        }

    }

    public static void pop() throws Exception{
        if(top < 0) {
            throw new Exception("Stack is Empty");
        }

        arr[top] = -1;
        top--;

        minArr[min] = -1;
        min--;

        maxArr[max] = -1;
        max--;
    }

    public static int peek() throws Exception{
        return arr[top];
    }

    public static int min() throws Exception {

        return minArr[min];

    }

    public static int max() throws Exception{

        return maxArr[min];
    }


}
