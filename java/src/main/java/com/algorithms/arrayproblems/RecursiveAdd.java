package com.algorithms.arrayproblems;
class RecursiveAdd {

    public static void main(String [] ar) {

        int [] arr = {6,3,2,1};

        System.out.println(add(arr,arr.length-1));

    }

    public static int add(int [] arr, int val) {
        if( val <= 0 ) {
            return arr[val];
        } else {
            return arr[val] + add(arr,--val);
        }
    }

}
