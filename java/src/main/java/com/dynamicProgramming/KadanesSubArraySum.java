package com.dynamicProgramming;

public class KadanesSubArraySum {

    //    static int [] arr = {2,1,-3,-4,5,6};
    static int[] arr = {12, 3, 5, -9, 11};

    public static void main(String[] args) {

        System.out.println(kadanes(arr));
        secondSmallest(arr);
        kadanes(arr, 8);
    }

    public static void kadanes(int[] arr, int sum) {

        int i = 0;
        int j = 0;
        int lowSum = arr[i];

        while ((i < arr.length && (j+1  ) < arr.length)) {

            if (sum - lowSum < 0) {
                i++;
                lowSum = arr[i];
                continue;
            }

            if (sum - lowSum > 0) {
                j++;
                lowSum = lowSum + arr[j];

            }

            if (sum - lowSum == 0) {
                System.out.println("i :: " + i + " :: j " + j);
                i++;
                j++;
                lowSum = arr[i];
            }
        }


    }

    public static int kadanes(int[] arr) {

        int sum = 0;
        int finalSum = 0;

        for (int i = 0; i < arr.length; i++) {

            sum = sum + arr[i];

            if ((sum + arr[i]) <= 0) {
                sum = 0;
            }

            if (finalSum < sum) {
                finalSum = sum;
            }

        }
        return finalSum;
    }

    public static void secondSmallest(int[] arr) {

        int first = 0;
        int second = 0;

        for (int i = 0; i < arr.length; i++) {
            if (first < arr[i]) {
                second = first;
                first = arr[i];
            } else if (second < arr[i]) {
                second = arr[i];
            }
        }
        System.out.println("First : " + first + "  :: Second :: " + second);
    }
}
