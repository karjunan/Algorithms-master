package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KadanesAlgorithm {

    public static void main(String[] args) {
        int[] arr = {-1, 2, 3, -4, 6};

        //{2,3,-4,6}
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(arr[i], arr[i] + sum);
            max = Math.max(sum, max);
            System.out.println(" Sum >>" + sum + " >> Max " + max);
        }

        System.out.println(max);

        System.out.println(Arrays.toString(arr));
        findSubArrayBruteForce(arr);
    }


    public static void findSubArrayBruteForce(int[] arr) {
        List<List<Integer>> finaList = new ArrayList<>();
        List<List<Integer>> finaSumList = new ArrayList<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> sumList = new ArrayList<>();
            sum = 0 ;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                list.add(arr[j]);
                sumList.add(sum);
                finaSumList.add(new ArrayList<>(sumList));
                finaList.add(new ArrayList<>(list));
            }
        }

        System.out.println(finaList);
        System.out.println(finaSumList);
    }
}
