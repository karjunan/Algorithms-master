package com.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NumberToWords {


    public static void main(String[] args) {
        int i = 1;
        StringBuffer sb = new StringBuffer();
//        String str = computeNumber(115);
//        print(str);
//        String newStr  = str.replace(" ", "");
//        sb.append(newStr);
//        print("["+newStr+"]");
//        System.out.println(sb.toString().length());
        while (i <= 1000) {
            String str = computeNumber(i);
            String newStr  = str.replace(" ", "");
            sb.append(newStr);
            System.out.println(sb.toString().length());
            i++;
        }
        System.out.println(sb.toString().length());
    }

    public static String computeNumber(int number) {
        String matcher = "";
        Stack<Integer> stack = new Stack<>();
        while (number / 10 != 0) {
            int val = number % 10;
            number = number / 10;
            stack.push(val);

        }
        stack.push(number);


        if (stack.size() == 1) {
            matcher += getValue(stack.pop());
        } else if (stack.size() == 2) {
            int top = stack.pop();
            int next = stack.pop();
            int mul = top * 10;
            int total = mul + next;
            if (total <= 20) {
                matcher = getValue(total);
            } else if (next == 0) {
                matcher += getValue(mul);
                matcher += " ";
            } else {
                matcher += getValue(mul);
                matcher += " ";
                matcher += getValue(next);
            }
        } else if (stack.size() == 3) {
            int hundreds = stack.pop();
            int tens = stack.pop();
            int ones = stack.pop();
            int mulHun = hundreds * 100;
            int mulTens = tens * 10;
            int addTens = mulTens + ones;
            int total = mulHun + addTens;
            matcher += getValue(hundreds);
            matcher += " ";
            matcher += getValue(100);
            if ( addTens > 0 && addTens <= 20) {
                matcher += " AND ";
                matcher += getValue(addTens);
            } else {
                if (tens != 0) {
                    matcher += " AND ";
                    matcher += getValue(mulTens);

                }
                if (ones != 0) {
                    matcher += " ";
                    matcher += getValue(ones);
                }

            }
        } else if (stack.size() == 4) {
            int thousand = stack.pop();
            matcher += getValue(thousand);
            matcher += " ";
            matcher += getValue(1000);
        }

        return matcher;
    }


    public static void print(String str) {
        System.out.println(str);
    }


    public static String getValue(Integer number) {

        Map<Integer, String> map = new HashMap<>();
        map.put(0, "ZERO");
        map.put(1, "ONE");
        map.put(2, "TWO");
        map.put(3, "THREE");
        map.put(4, "FOUR");
        map.put(5, "FIVE");
        map.put(6, "SIX");
        map.put(7, "SEVEN");
        map.put(8, "EIGHT");
        map.put(9, "NINE");
        map.put(10, "TEN");
        map.put(11, "ELEVEN");
        map.put(12, "TWELVE");
        map.put(13, "THIRTEEN");
        map.put(14, "FOURTEEN");
        map.put(15, "FIFTEEN");
        map.put(16, "SIXTEEN");
        map.put(17, "SEVENTEEN");
        map.put(18, "EIGHTEEN");
        map.put(19, "NINETEEN");
        map.put(20, "TWENTY");
        map.put(30, "THIRTY");
        map.put(40, "FORTY");
        map.put(50, "FIFTY");
        map.put(60, "SIXTY");
        map.put(70, "SEVENTY");
        map.put(80, "EIGHTY");
        map.put(90, "NINETY");
        map.put(100, "HUNDRED");
        map.put(1000, "THOUSAND");

        return map.get(number);

    }
}
