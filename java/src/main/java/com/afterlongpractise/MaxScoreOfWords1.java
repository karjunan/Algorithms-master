package com.afterlongpractise;

import java.util.*;
import java.util.stream.Collectors;

public class MaxScoreOfWords1 {

    public static void main(String[] args) {
        String[] words = new String[]{"dog","cat","dad","good"};
        char[] letters =  new char[] {'a','a','c','d','d','d','g','o','o'};
        int[] score    = new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int val = maxScoreWords(words,letters,score);
        System.out.println("Value is " + val);
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {

        Map<Character, Integer> letterMap = new HashMap<>();
        Map<Character, Integer> scoreMap = new HashMap<>();


        for(char ch: letters) {
            letterMap.compute(ch, (key,value) -> value == null ? 1 : value + 1);

        }

        for(int i = 0 ; i < score.length; i++) {
            char ch= (char)((int)'a'+i);
            if(score[i] == 0) {
                continue;
            }
            scoreMap.put(ch,score[i]);
        }
        List<Result> list = new ArrayList<>();
        List<String> input =  Arrays.stream(words).collect(Collectors.toList());
        helper(input,new ArrayList<String>(),letterMap,scoreMap,list);
        int max = Integer.MIN_VALUE;
        //  System.out.println(list);
        for (Result entry : list) {
            max = Math.max(max, entry.total);
        }

        return max;
    }

    public static void helper(List<String> input, List<String> output, Map<Character,Integer> letterMap, Map<Character,Integer> scoreMap,
                              List<Result> list) {

        if(input.isEmpty()) {
            Map<Character, Integer> letterMap1 = new HashMap(letterMap);
            int totalScore = 0;
            for (String word : output) {
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
                //  System.out.println(letterMap1 + " :: " +  individualScore);
            }
            //resultMap.put(words,totalScore);
            Result result = new Result(output, totalScore);
            list.add(result);
            //System.out.println(Arrays.toString(words)  + " : : " + resultMap.get(words));
            // System.out.println(output);
            return;
        }


        String word = input.remove(0);
        output.add(word);
        helper(input,output,letterMap,scoreMap,list);
        output.remove(output.size()-1);
        helper(input,output,letterMap,scoreMap,list);
        input.add(word);
    }

    public static void swap(int i, int j, String[] words) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

    static class Result {
        List<String> words;
        Integer total;

        Result(List<String> words, Integer total) {
            this.words = words;
            this.total = total;
        }

        public String toString() {
            return words + " => " + total;
        }
    }




}
