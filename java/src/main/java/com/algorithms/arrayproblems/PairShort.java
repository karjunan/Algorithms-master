package com.algorithms.arrayproblems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class PairShort {

    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] arr) {

        Arrays.sort(arr);
        int j = 1;
        int min = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < arr.length - 1; i++, j++) {
            int val = Math.abs(arr[j] - arr[i]);
            if (val <= min) {
                    min = val;
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    map.compute(min, (k, v) -> {
                        if (v == null) {
                            List<Integer> fList = new ArrayList<>();
                            fList.addAll(list);
                            return fList;
                        } else {
                            List<Integer> llist = map.get(k);
                            llist.addAll(list);
                            return llist;
                        }
                    });
            }

        }

        System.out.println("Min Value : " + map);

        List<Integer> ls = ((TreeMap<Integer, List<Integer>>) map).firstEntry().getValue();

        return ls.stream().sorted().mapToInt(v -> v.intValue()).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        arr = new int[arrItems.length];
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrItems.length; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
//            System.out.println(arrItem);
            arr[i] = arrItem;
        }

        int[] result = closestNumbers(arr);

//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write(" ");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}

