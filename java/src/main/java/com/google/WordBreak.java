package com.google;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordBreak {


    public static void main(String[] args) {
//       String s = "codeleet";
//       String[] wordDict = new String [] {"leet", "coe", "lee","co","ode", "de"};
        String s = "code";
        String[] wordDict = new String [] {"co", "d", "de","e"};

        boolean isTrue = wordBreak(s,Arrays.stream(wordDict).collect(Collectors.toList()),new HashMap<String,Boolean>());
//      boolean isTrue = wordBreakDP(s,Arrays.stream(wordDict).collect(Collectors.toList()));

        System.out.println( "Result is => " + isTrue);
    }

    public static boolean wordBreakDP(String s,List<String> wordDict ) {

        boolean [] dp = new boolean[s.length()+ 1];
        dp[0] = true;

        for(int i = 1 ; i < dp.length; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                }
//                System.out.println(Arrays.toString(dp));
            }
        }

        return dp[dp.length-1];
    }

    public static boolean wordBreakWithMemozation(String s, List<String> wordDict, Map<String,Boolean> map) {

        if(s.equals("")) {
            return true;
        }

        if(map.containsKey(s)) {
            return map.get(s);
        }

        for(int i = 1 ; i <= s.length(); i++) {
            String subString = s.substring(0,i);
            System.out.println(subString);
            if(wordDict.contains(subString) && wordBreakWithMemozation(s.substring(i, s.length()),wordDict,map)) {
                map.put(s,true);
                return true;
            }
        }
        return false;
    }


    public static boolean wordBreak(String s, List<String> wordDict, Map<String,Boolean> map) {

        if(s.equals("")) {
            System.out.println("Got the value => empty ");
            return true;
        }
//
//        if(map.containsKey(s)) {
//            return map.get(s);
//        }

        for(int i = 1 ; i <= s.length(); i++) {
            String subString = s.substring(0,i);
            System.out.println(subString);
            if(wordDict.contains(subString) && wordBreak(s.substring(i, s.length()),wordDict,map)) {
                System.out.println("String is => " + s);
                map.put(s,true);
                return true;
            }
        }
        return false;
    }

}
