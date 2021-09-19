package com.algorithms.arrayproblems;

import java.util.LinkedHashMap;
import java.util.Map;

public class ZigZagConversion {

    static String str = "PAYPALISHIRING";
    static int numRows = 4;
    public static void main(String [] ar) {

//        convert(str,numRows);
        System.out.println(convertUsing2DMatrix(str,numRows));
    }

    public static String convertUsing2DMatrix(String s, int numRows) {

        int [][] arr = new int[numRows][numRows];
        for(int i = 0 ; i < numRows; i++) {
            for(int j = 0 ; j < arr[i].length;i++) {
                System.out.print(arr[i][0] + "   ");
            }
            System.out.println("\n");
        }

        return "";

    }

    public static String convert(String s, int numRows) {

            Map<Integer, String> map = new LinkedHashMap<>();
            int val = 0;
            int col = 0;
            int i = 0;
            while(i < s.length()) {
                StringBuffer buffer = new StringBuffer();
                String fin = s.substring(val,s.length());
                if(fin.length() < numRows) {
                    map.put(++col,fin);
                    break;
                }
                while (val < (i + numRows)) {
                    buffer.append(s.charAt(val));
                    val++;
                }
                col++;
                map.put(col, buffer.toString());
                System.out.println("Column >> " + col + ">>" +  map + " >>   " + i);
                i = val;
                int midValues = numRows - 2;
                while (midValues > 0) {
                    map.put(++col, Character.toString(s.charAt(i++)));
                    midValues--;
                }
                val = val + (numRows - 2);
                System.out.println(map);
                i = val;
            }
            System.out.println("Final Result >> " + map);


            return "";
        }

}
