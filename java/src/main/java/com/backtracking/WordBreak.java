package com.backtracking;

import java.util.HashSet;

public class WordBreak {


    static HashSet<String> set = new HashSet<>();

    public static void main(String [] args) {

        set.add("i");
        set.add("like");
        set.add("sam");
        set.add("sung");
        set.add("samsung");
        set.add("mobile");
        set.add("ice");
        set.add("cream");
        set.add("icecream");
        set.add("man");
        set.add("go");
        set.add("mango");

        String str = "icecreamgomango";

        wordBreak(str,"",str.length());
    }

    public static void wordBreak(String in, String out, int n ) {
         System.out.println(in + " :: " + out + " : " + n );
        for( int i = 0 ; i <= n; i++ ) {
            // System.out.println("i " + i + in);
            String prefix = in.substring(0,i);
            // System.out.println("Prefix : "+ prefix + ": " + i + ":: " + n);

            if( n == 0 ) {
                System.out.println("Result final >> " + out);
                out = out + prefix;
                return;
            }

            if(set.contains(prefix)) {
                wordBreak(in.substring(i, n),out + prefix + " ",n-i);
            }

        }

    }


    public static void print(int [][] maze) {
        System.out.println("\n");
        for( int i = 0 ; i < maze.length;i++) {
            for( int j = 0 ; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");

            }
            System.out.println(" ");
        }
        System.out.println("");
    }



}
