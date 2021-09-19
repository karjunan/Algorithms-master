package com.backtracking;

import java.util.Arrays;

public class BalancedParantheses {

    public static void main(String[] args) {

        int n = 3;

        paran(n);


    }

    public static void paran(int n) {
        char [] ch = new char[n*2];
        paran(n,n,ch, 0);
    }

    public static void paran(int left, int right, char[] ch,
                             int pos) {

        // System.out.println(list);

        if( left == 0 ) {
            // ch[pos] = '}';
            System.out.println(Arrays.toString(ch));
            return;
        }

        if( right > left ) {
            ch[pos] = '}';
            paran(left, right-1, ch,pos+1);

        }

        if( left > 0 ) {
            ch[pos] = '{';
            paran(left-1, right, ch,pos+1);

        }


    }

}
