package com.algorithms.algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinHeap {

    public static void main(String[] args) {

        int [] arr = {4,6,2,8,9,1,7,-3};
        ArrayList<Integer> list = Arrays.stream(arr).mapToObj(i -> Integer.valueOf(i)).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list);
        buildHeap(list);
        System.out.println(list);
    }

    public static void buildHeap(ArrayList<Integer> heap) {
        int parent = (heap.size()-1)/2;

        int i = parent;
        while(i >= 0 ) {
            System.out.println("------end----------");
            shiftDown(heap,i,heap.size()-1);
            i--;
            System.out.println("------start----------");
        }

    }

    public static void shiftDown(ArrayList<Integer> heap, int currentIdx, int endIdx) {


        while(true) {
            int leftChild = (currentIdx * 2) + 1;
            int rightChild = (currentIdx * 2) + 2;

            //only one childNode
            if(leftChild <= endIdx && rightChild > endIdx) {
                if(heap.get(leftChild) < heap.get(currentIdx)) {
                    Collections.swap(heap,leftChild,currentIdx);
                } else {
                    break;
                }
                currentIdx = leftChild;
            } else if(leftChild <= endIdx && rightChild <= endIdx) {
                //both children are there
                int pos = -1;
                if(heap.get(leftChild) < heap.get(rightChild)) {
                    pos = leftChild;
                } else {
                    pos = rightChild;
                }

                if(heap.get(pos) < heap.get(currentIdx)) {
                    Collections.swap(heap,pos,currentIdx);
                }
                currentIdx = pos;
            } else {
                // elements greater than the index location
                break;
            }

        }
        System.out.println(heap);
    }


//    public static ArrayList<Integer> buildHeap(ArrayList<Integer> array){
//
//        int i = getParent(array.size()-1);
//        while(i >= 0) {
//            shiftDown(i,array.size()-1,array);
//            // p(array);
//            i--;
//        }
//        System.out.println("Build MaxHeap - > " +array);
//        return null;
//    }

//   public static void shiftDown(int currentIdx,int endIdx, ArrayList<Integer> heap) {

//     int left = getLeftChild(currentIdx);
//     int right = getRightChild(currentIdx);

//          System.out.println(currentIdx +  " = " + endIdx + " = " + left + " = "+ right);


//   if(left <= endIdx && right > endIdx && heap.get(currentIdx) >     heap.get(left) ) {
//       Collections.swap(heap,left,currentIdx);
//     return;
//    }

//      while(left <= endIdx && right <= endIdx) {

//        int pos = 0;
//        if(heap.get(left) < heap.get(right)) {
//          pos = left;
//        } else {
//          pos = right;
//        }

//        if(heap.get(pos) < heap.get(currentIdx)) {
//          Collections.swap(heap,pos,currentIdx);
//        }
//        currentIdx = pos;
//        left = getLeftChild(currentIdx);
//        right = getRightChild(currentIdx);
//     }

//   if(left <= endIdx && right > endIdx && heap.get(currentIdx) >     heap.get(left) ) {
//       Collections.swap(heap,left,currentIdx);
//    }



//   }

    public static void shiftDown(int currentIdx,int endIdx, ArrayList<Integer> heap) {

        int left = getLeftChild(currentIdx);
        int right = getRightChild(currentIdx);

        while(left <= endIdx && right <= endIdx) {
            int pos = 0;
            if(heap.get(left) < heap.get(right)) {
                pos = left;
            } else {
                pos = right;
            }

            if(heap.get(pos) < heap.get(currentIdx)) {
                Collections.swap(heap,pos,currentIdx);
            }
            currentIdx = pos;
            left = getLeftChild(currentIdx);
            right = getRightChild(currentIdx);
        }

        System.out.println(heap);

    }


    public static void shiftUp(int currentIdx, ArrayList<Integer> heap) {

        int parent =  getParent(currentIdx);
        while(parent >= 0 && heap.get(parent) > heap.get(currentIdx)) {
            Collections.swap(heap,parent,currentIdx);
            currentIdx = parent;
            parent = getParent(currentIdx);
        }

    }

//    public static int peek() {
//        if(list.isEmpty()){
//            return -1;
//        }
//        return list.get(0);
//    }
//
//    public static int remove() {
//        int val = list.get(0);
//        Collections.swap(list,0,list.size()-1);
//        list.remove(list.size()-1);
//        shiftDown(0,list.size()-1,list);
//        System.out.println("Remove -> " + list);
//        return val;
//    }
//
//    public static void insert(int value) {
//        list.add(value);
//        shiftUp(list.size()-1,list);
//        System.out.println("Insert -> " + list);
//
//    }


    public static void p(ArrayList<Integer> list){
        System.out.println(list);
    }

    private static int getParent(int currentIdx) {
        Double floor = Math.floor((currentIdx-1)/2);
        return floor.intValue();
    }

    public static int getLeftChild(int currentIdx) {
        return (2*currentIdx)+1;
    }


    public static int getRightChild(int currentIdx) {
        return (2*currentIdx)+2;
    }


}
