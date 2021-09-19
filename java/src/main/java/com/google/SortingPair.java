package com.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingPair {


    public static void main(String[] args) {
        int[][] people = new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
//         List<Integer[]> ls = convertToList(people);
//         print(ls);
         customSort(people);
        System.out.println(Arrays.deepToString(people));
//         print(ls);
         reconstructQueue(people);
    }

    public static void reconstructQueue(int[][]  people) {


        int [][] finalList = new int[people.length][2];
        for(int i = 0 ; i < finalList.length ; i++) {
            finalList[i][0] = -1;
            finalList[i][1] = -1;
        }

        System.out.println(Arrays.deepToString(finalList));
        for(int i = 0 ; i < people.length; i++) {
            int height  = people[i][0];
            int counter = people[i][1];
            for( int j = 0; j < people.length; j++) {
                if(finalList[j][0] == -1 && counter == 0 ) {
                    finalList[j][0] =  people[i][0];
                    finalList[j][1] =  people[i][1];
                    break;
                } else if(finalList[j][0] == -1 && counter > 0 ) {
                    counter--;
                } else if(finalList[j][0] >= height) {
                    counter--;
                }
                System.out.println(Arrays.deepToString(finalList));
            }
            System.out.println(Arrays.deepToString(finalList));
        }

        System.out.println(Arrays.deepToString(finalList));

    }



    public static List<Integer[]> convertToList(int [][] people) {
        List<Integer[]> list = new ArrayList<>();
        for(int i = 0 ; i < people.length; i++) {
                Integer[] k = new Integer[2];
                k[0] = people[i][0];
                k[1] = people[i][1];
                list.add(k);
        }
        return list;
    }

    public static void customSort(int[][] people ) {
        Arrays.sort(people,(k1,k2) -> {
            if(k1[0] < k2[0]) {
                return -1;
            } else if(k2[0] < k1[0]) {
                return 1;
            } else  {
                if(k1[1] < k2[1]) {
                    return -1;
                } else if(k1[1] > k2[1]) {
                    return 1;
                }
                return 0;
            }
        });
    }

    public static void print(List<Integer[]> list ) {
        System.out.println("----------------------------------------");
//        Comparator<Integer[]> comparator = (s1,s2) -> s1[0].compareTo(s2[0]);
        list.forEach(v -> System.out.print(Arrays.toString(v)));
        System.out.println("---------------End----------------------");
    }
}
