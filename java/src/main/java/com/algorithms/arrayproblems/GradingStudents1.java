package com.algorithms.arrayproblems;

import java.util.*;

public class GradingStudents1 {

    static String [][] str= { { "Barry", "-66" },
            { "Barry", "-65" },
            { "Alfred", "-122"} };

    public static void main(String[] args) {
        System.out.println(bestAverageGrade(str));

    }
        /*
         **  Find the best average grade.
         */
        public static Integer bestAverageGrade(String[][] scores) {
            Map<String, List<Integer>> studentMarksMap = new HashMap<>();
            Map<String, Integer> averageScoreMap = new HashMap<>();


            for (int row = 0; row < scores.length; row++) {


                if (studentMarksMap.containsKey(scores[row][0])) {
                    List<Integer> scoreList = new ArrayList<>();
                    scoreList.addAll(studentMarksMap.get(scores[row][0]));
                    scoreList.add(Integer.parseInt(scores[row][1]));
                    studentMarksMap.put(scores[row][0], scoreList);
                } else {
                    studentMarksMap.put(scores[row][0], Arrays.asList(Integer.parseInt(scores[row][1])));
                }


            }

            studentMarksMap.forEach((key, value) -> {

                int sum = 0;

                if (value.size() == 1) {
                    averageScoreMap.put(key, value.get(0));
                } else {

                    for (int marksSum : value) {

                        sum += marksSum;
                    }
                    float averageMarks = sum / value.size();
//                    averageScoreMap.put(key, Math.floor(averageMarks));
                }
            });

            System.out.println(averageScoreMap);

            int returnValue = Collections.max(averageScoreMap.entrySet(), (e1, e2) -> e1.getValue() - e2.getValue()).getValue();
            return returnValue;
        }

}
