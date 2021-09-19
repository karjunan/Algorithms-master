package com.google;

import java.util.Arrays;

public class MaxHeap {
    static int [] arr = new int[10];
    static int position = 0;


    public static void main(String[] args) {
//        Arrays.fill(arr,Integer.MIN_VALUE);
        arr = new int [] {1,10,2,20,45,23,50};
        position = arr.length;
        print();
        int current = ((arr.length-1)/2)-1;
        for(int i = current ; i >= 0 ; i--) {
            heapify(current);
            print();
        }
//        print();
    }

    public static void print() {
        System.out.println(Arrays.toString(arr));
    }

    public static void insert(int num) {
        if(arr[0] == Integer.MIN_VALUE) {
            arr[0] = num;
            position++;
        } else {
            arr[position] = num;
            int current = position;
            int parent = current/2;
            while(parent >= 0 && arr[parent] < num) {
                swap(arr, parent, current);
                current = parent;
                parent = current / 2;
            }
            position++;
        }
    }

    public static void swap(int [] arr, int a, int b) {
        System.out.println("Swapping ----- ");
        print();
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

        print();
        System.out.println("Finished Swapping ----- ");
    }
    public static int delete() {

        int val = arr[0];
        pushDown(1,position,0);
        position--;

        System.out.println("Current Position => "+ position);
        return val;

    }


    public static int get() {

        return arr[0];
    }

    public static void heapify(int current) {

        int right = 2*current;
        int left = (2*current)-1;


        while(left <= position && right <= position) {
            System.out.println("Position is => " + position + ": " + arr[left] + " : " + arr[right] + ":" + arr[current]);
            int max = left;
            if(arr[left] < arr[right]) {
                max = right;
            }
            if(arr[max] > arr[current]) {
                swap(arr,max,current);
            } else {
                break;
            }

            current = max;
            right = (2*current);
            left = (2*current)-1;
        }

    }

    private static void pushDown(int height, int position, int current){
        arr[current] = arr[position];
        while((2*height) <= position && (2*height)-1 <= position) {
            int right = (2*height);
            int left = (2*height)-1;
            int max = left;
            if(arr[left] < arr[right]) {
                max = right;
            }
            if(arr[max] > arr[current]) {
                swap(arr,max,current);
            } else {
                break;
            }
            current = max;
            height++;
        }

    }
}
