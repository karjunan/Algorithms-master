package com.algorithms.arrayproblems;

import java.util.Arrays;

class UniqueCharacters {


    public static void main(String[] args) {

        String str = "abd";

        System.out.println(str);

        char[] ch = str.toCharArray();
        Arrays.sort(ch);

        System.out.println(Arrays.toString(ch));
        int i = 0 ,j = 1;
        boolean bool = false;
        while( j < ch.length) {

            if(ch[i] == ch[j]) {
                bool = true;
                break;
            } else {
                i++;
                j++;
            }
        }

        if(bool)
            System.out.println("Redundancy Found");
        else
            System.out.println("Uniqueness Found ");

    }


}
