package com.algorithms.arrayproblems;

import java.util.Arrays;

public class ChangeSpaceToDifferentCharacter {


    public static void main(String[] args) {

        String str = "Hello from Krishna";
        char[] ch = str.toCharArray();

        System.out.println(Arrays.toString(ch));

        int counter= 0;
        for(int i = 0 ; i < ch.length ; i++) {
            if(ch[i] == ' ') {
                System.out.println("Space : " +(int)ch[i]);
                counter++;
            }
        }

        char [] ch1 = new char[ch.length + (counter*2)];

        for( int i = 0,j=0 ; i < ch1.length && j < ch.length;i++,j++) {
            ch1[i] = ch[j];
            if(ch[j] == ' ') {
                ch1[i] =(char)37;
                ch1[++i] = (char)50;
                ch1[++i] = (char)48;

            }
            System.out.println(Arrays.toString(ch1));
        }

        System.out.println(new String(ch1));

    }
}

