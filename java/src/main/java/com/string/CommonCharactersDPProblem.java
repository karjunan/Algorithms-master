package com.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommonCharactersDPProblem {
//     static String [] str = {"bella","label","roller"};
    static String [] str = {"roller","ll"};

    public static void main(String[] args) {

        List<String> list = commonChars(str);

        System.out.println(list);
    }

    public static List<String> commonCharsdp(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A) {
            int[] cnt = new int[26];
            for (int i = 0; i < str.length(); ++i) {
                ++cnt[str.charAt(i) - 'a'];

            } // count each char's frequency in string str.
            System.out.println(Arrays.toString(cnt));
            for (int i = 0; i < 26; ++i) {
                count[i] = Math.min(cnt[i], count[i]);
            } // update minimum frequency.
            System.out.println(Arrays.toString(count));
        }

        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) { ans.add("" + c); }
        }

        return ans;
    }

    public static List<String> commonChars(String[] A) {

        Map<Character,Integer> map = new ConcurrentHashMap<>();
        for(int j = 0 ; j < A[0].toCharArray().length; j++) {
            char ch = A[0].charAt(j);
            if(!map.containsKey(ch)) {
                map.put(ch,1);
            } else {
                map.put(ch,map.get(ch)+1);
            }
        }
        // System.out.println("First  -> " + map);
        for(int i = 1; i < A.length; i++) {
            Map<Character,Integer> internalMap = new HashMap<>();
            for( int j = 0 ; j < A[i].toCharArray().length; j++ ) {
                char ch = A[i].charAt(j);
                if(!internalMap.containsKey(ch)) {
                    internalMap.put(ch,1);
                } else {
                    internalMap.put(ch,internalMap.get(ch)+1);
                }
            }
            // System.out.println("Second  -> " + internalMap);

            for(Map.Entry<Character,Integer> entry: internalMap.entrySet()) {
                if(map.containsKey(entry.getKey())) {
                    if(entry.getValue() < map.get(entry.getKey())) {
                        map.put(entry.getKey(),entry.getValue());
                    }
                }
            }
            // System.out.println("Third  -> " + map);

            for(Map.Entry<Character,Integer> entry: map.entrySet()) {
                if(!internalMap.containsKey(entry.getKey())) {
                    map.remove(entry.getKey());
                }
            }

            // System.out.println("Fourth  -> " + map);


        }
        List<String> list = new ArrayList<>();
        for(Map.Entry<Character,Integer> entry: map.entrySet()) {
            int i = 0;
            while(i < entry.getValue())
            {
                list.add(Character.toString(entry.getKey()));
                i++;
            }
        }
        // System.out.println("Output -> " + list);
        return list;
    }
}
