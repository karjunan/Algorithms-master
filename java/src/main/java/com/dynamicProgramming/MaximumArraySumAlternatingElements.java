package com.dynamicProgramming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MaximumArraySumAlternatingElements {


    static int arr [] = {-2,1,3,-4,5};
//    static  int arr [] = {1, 2, -2, 3, 11, 9};
//    static int arr [] = {3, 7, 4, 6, 5};
//    static int arr [] = {2, 1, 5, 8, 4};
    //static int arr [] = {3, 5, -7, 8, 10};

    //output = 7412694
    public static void main(String[] args) throws IOException {

        List<String> list = Files.readAllLines(Paths.get("src","main","resources","data.txt"));
        System.out.println(list);
        System.out.println(list.size());
        String [] str = list.get(0).split(" ");
        System.out.println(str.length);
//        arr = Stream.of(str).mapToInt(v -> Integer.parseInt(v)).toArray();
        System.out.println("Array Length " + arr.length);
//        IntStream.of(arr).forEach(System.out::println);
//        calculateWithoutList(arr);
//        calculate(arr);

        System.out.println(maxSubsetSum(arr));
    }

    public static void calculateWithoutList(int [] arr) {

        int i = 0 ;
        int j = 2;
        int finalSum = 0;
        while( i < arr.length ) {
            int evenSum = arr[i];
            while(j < arr.length ) {
                int sum = arr[i];
                if (i % 2 == 0) {

                    if (j % 2 == 0) {
                        if(evenSum < evenSum+arr[j])
                            evenSum = evenSum + arr[j];
                    } else {
                        if(finalSum < (sum + arr[j])) {
                            finalSum = arr[i] + arr[j];
                        }
                    }
                } else {
                    if (j % 2 != 0) {
                        if(evenSum < evenSum+arr[j])
                            evenSum = evenSum + arr[j];
                    } else {
                        if(finalSum < (sum + arr[j])) {
                            finalSum = arr[i] + arr[j];
                        }
                    }
                }
                j++;
            }

            i++;
            j = i+2;
            if(evenSum > finalSum) {
                finalSum = evenSum;
            }
        }

        System.out.println("Final Sum " + finalSum );

    }

    public static void print(int [][] arr) {
        for( int i = 0 ; i < arr.length; i++) {
            for(int j = 0 ; j < arr[i].length; j++) {
                System.out.print("    " +arr[i][j]);
            }
            System.out.println("");
        }
        System.out.println( "\n \n" );
    }


    public static void calculate(int [] arr) {

        int i = 0 ;
        int j = 2;
        List<Integer> list = null;
        List<List<Integer>> finalList = new ArrayList<>();
        while( i < arr.length ) {
            list = new ArrayList<>();
            list.add(arr[i]);
            while(j < arr.length ) {

                if (i % 2 == 0) {

                    if (j % 2 == 0) {
                        list.add(arr[j]);
                        List<Integer> fList = new ArrayList<>();
                        fList.add(arr[i]);
                        fList.add(arr[j]);
                        finalList.add(fList);
                    } else {
                        List<Integer> nList = new ArrayList<>();
                        nList.add(arr[i]);
                        nList.add(arr[j]);
                        finalList.add(nList);
                    }
                } else {
                    if (j % 2 != 0) {
                        list.add(arr[j]);
                    } else {
                        List<Integer> nList = new ArrayList<>();
                        nList.add(arr[i]);
                        nList.add(arr[j]);
                        finalList.add(nList);
                    }
                }
                j++;
            }
            if(list.size() > 1) {
                finalList.add(list);
            }
//            System.out.println(finalList);
            i++;
            j = i+2;
        }

        int finalOutput = finalList.stream().mapToInt(v -> v.stream().mapToInt(k -> k.intValue()).sum())
                .max().getAsInt();
        System.out.println("Final Output :: "  + finalOutput);
    }

    static int maxSubsetSum(int[] arr) {

        int incl = 0;
        int excl = 0;
        int temp = 0;

        for(int i = 0; i < arr.length; i++) {
            temp = incl;
            incl = Math.max(arr[i]+excl, temp);
            excl = temp;
        }
        return Math.max(incl, excl);
    }

}
