package com.afterlongpractise;

import java.util.*;

public class MaxScoreOfWords {

    public static void main(String[] args) {
        String[] words = new String[]{"dog","cat","dad","good"};
        char[] letters =  new char[] {'a','a','c','d','d','d','g','o','o'};
        int[] score    = new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int result = maxScoreWords(words,letters,score);
        System.out.println("Result is => " + result);
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {

        Map<Character, Integer> letterMap = new HashMap<>();
        Map<Character, Integer> scoreMap = new HashMap<>();


        for (char ch : letters) {
            letterMap.compute(ch, (key, value) -> value == null ? 1 : value + 1);

        }

        for (int i = 0; i < score.length; i++) {
            char ch = (char) ((int) 'a' + i);
            if (score[i] == 0) {
                continue;
            }
            scoreMap.put(ch, score[i]);
        }

        //  System.out.println(letterMap);
        //  System.out.println(scoreMap);
        List<Result> list = new ArrayList<>();

        helper(letterMap, scoreMap, words, 0, list);
        int max = Integer.MIN_VALUE;
        //  System.out.println(list);
        for (Result entry : list) {
            max = Math.max(max, entry.total);
        }

        return max;
    }

    public static void helper(Map<Character, Integer> letterMap, Map<Character, Integer> scoreMap, String[] words, int end,
                              List<Result> list) {

        if (end == words.length) {
            Map<Character, Integer> letterMap1 = new HashMap(letterMap);
            int totalScore = 0;
            for (String word : words) {
                int individualScore = 0;
                for (char ch : word.toCharArray()) {
                    if (letterMap1.containsKey(ch)) {
                        int val = letterMap1.get(ch) - 1;
                        if (val < 0) {
                            letterMap1.remove(ch);
                            individualScore = 0;
                            break;
                        } else {
                            letterMap1.put(ch, val);
                            individualScore = individualScore + scoreMap.get(ch);
                        }
                    } else {
                        individualScore = 0;
                        break;
                    }
                }
                totalScore = totalScore + individualScore;
                System.out.println(letterMap1 + " :: " +  individualScore);
            }
            //resultMap.put(words,totalScore);
            Result result = new Result(words, totalScore);
            //list.add(result);
            //System.out.println(Arrays.toString(words)  + " : : " + resultMap.get(words));
            return;
        }

        for (int i = end; i < words.length; i++) {
            swap(i, end, words);
            helper(letterMap, scoreMap, words, end + 1, list);
            swap(i, end, words);
        }

    }

    public static void swap(int i, int j, String[] words) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

    static class Result {
        String[] words;
        Integer total;

        Result(String[] words, Integer total) {
            this.words = words;
            this.total = total;
        }

        public String toString() {
            return Arrays.toString(words) + " => " + total;
        }
    }

}
