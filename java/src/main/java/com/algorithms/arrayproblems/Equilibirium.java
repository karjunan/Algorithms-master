package com.algorithms.arrayproblems;

public class Equilibirium {

    public static void main(String[] args) throws Exception {
        // Integer [] arr  = {1, 4, 45, 6, 0, 19};
        Integer [] arr  = {1};
        int min = equilibirium(arr);
        System.out.println(min);
    }


    public static int equilibirium(Integer [] arr) throws Exception {
        int front=0;
        int last = arr.length-1;
        int frontSum=0;
        int lastSum=0;
        if(arr[front] == arr[last]) {
            return 1;
        } else {
            lastSum=lastSum+arr[last];
            frontSum = frontSum+arr[front];
            while(true) {
                // System.out.println("Inside while");
                System.out.println( frontSum + " :: " + lastSum );
                if(frontSum > lastSum) {
                    last--;
                    lastSum=lastSum+arr[last];
                }

                if(frontSum < lastSum) {
                    front++;
                    frontSum = frontSum+arr[front];
                }

                if(frontSum == lastSum) {
                    System.out.println("Found mid :" +frontSum);
                    System.out.println("Index " + Math.abs(front-last));
                    break;
                }


            }
            return front;
        }
    }
}
