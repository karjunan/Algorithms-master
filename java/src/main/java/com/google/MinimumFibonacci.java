package com.google;

import java.util.ArrayList;
import java.util.List;

public class MinimumFibonacci {

    public static void main(String[] args) {
        int result = findMinFibonacciNumbers(100);
        System.out.println("Min Fibonaccit is => " + result);
    }

        public static int findMinFibonacciNumbers(int k) {
            List<Integer> ls = findFibonacci(k);
            int temp = k;
            int counter = 0;
            for(int i = ls.size()-1 ; i >= 0 ; i--) {
                if(ls.get(i) <= temp && temp > 0 ) {
                    temp = temp - ls.get(i);
                    counter ++;
                }
            }

            return counter;
        }

        public static List<Integer> findFibonacci(int k) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            list.add(1);
            int i = 3;
            int temp = 0;
            while (temp <= k) {
                temp = list.get(i-1) + list.get(i-2);
                list.add(temp);
                if(temp >= k) {
                    break;
                }
                i++;
            }
            return list;
        }
    }

