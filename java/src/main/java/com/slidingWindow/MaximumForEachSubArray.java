package com.slidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumForEachSubArray {

    public static void main(String[] args) {
//        int [] arr = new int[] {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int [] arr = new int[] {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        System.out.println("Elements are => " + dequeue(arr,k));
        printMax(arr,arr.length,k);
    }

    public static List<Integer> dequeue(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        int windowEnd =0 ;
        for( ; windowEnd < k; ++windowEnd) {
            while(!deque.isEmpty() && arr[windowEnd] >= arr[deque.peekLast()]) {
                deque.removeLast();
                System.out.println(deque);
            }
           deque.addLast(windowEnd);
        }

        for(; windowEnd < arr.length; ++windowEnd) {
            list.add(arr[deque.peekFirst()]);
            System.out.println(list + " => " + arr[deque.peekFirst()]);
            while(!deque.isEmpty() && deque.peek() <= windowEnd - k) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && arr[windowEnd] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(windowEnd);
            System.out.println("Dequeue => " + deque);
        }

        list.add(arr[deque.peekFirst()]);

//        System.out.println(deque);
        return list;
    }

    public static void printMax(int arr[], int n, int k)
    {
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window) elements of array */
        int i;
        for (i = 0; i < k; ++i) {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast(); // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    }
}
