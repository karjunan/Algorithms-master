package pramp;


import java.util.LinkedHashMap;
import java.util.Map;

public class BusiestTimeInMall {

    public static void main(String[] args) {
            int [][] data =  {
                    {1487799425, 14, 1},
                    {1487799425, 4,  0},
                    {1487799425, 2,  0},
                    {1487800378, 10, 1},
                    {1487801478, 18, 0},
                    {1487801478, 18, 1},
                    {1487901013, 1,  0},
                    {1487901211, 7,  1},
                    {1487901211, 7,  0}};

            int result = findBusiestPeriod(data);
            int result1= solution1(data);
            System.out.println("The final output is =>" + result  + " == " + result);
    }

    public static int findBusiestPeriod(int[][] data) {
        if(data.length == 1) {
            return data[0][0];
        }

        int prevCount = 0;
        int currentCount = 0;
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < data.length; i++) {

            int [] currentData = data[i];

            if(currentData[2] == 1) {
                currentCount += currentData[1];
            } else {
                currentCount -= currentData[1];
            }

            if(i < data.length - 1 && currentData[0] == data[i+1][0]) {
                continue;
            }

            if(currentCount > max) {
                max = currentCount;
                maxIndex = currentData[0];
            }
            System.out.println(currentCount + " == " + max + " == " + maxIndex);
        }

        return maxIndex;
    }

    static int solution1(int[][] data) {

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for(int[] current: data) {
            if(!map.containsKey(current[0])) {
                if(current[2] == 1) {
                    map.put(current[0], current[1]);
                } else {
                    map.put(current[0], 0 - current[1]);
                }
            } else {
                int value = map.get(current[0]);
                if(current[2] == 1) {
                    map.put(current[0], value + current[1]);
                } else {
                    map.put(current[0], value - current[1]);
                }
            }
        }

        int totalSum = 0;
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(Map.Entry<Integer, Integer> entrySet: map.entrySet()) {

            totalSum += entrySet.getValue();
            if(max < totalSum) {
                max = totalSum;
                index = entrySet.getKey();
            }

        }

        return index;

    }

}


/*

The Westfield Mall management is trying to figure out what the busiest moment at the mall was last year. You’re given data extracted from the mall’s door detectors. Each data point is represented as an integer array whose size is 3. The values at indices 0, 1 and 2 are the timestamp, the count of visitors, and whether the visitors entered or exited the mall (0 for exit and 1 for entrance), respectively. Here’s an example of a data point: [ 1440084737, 4, 0 ].

Note that time is given in a Unix format called Epoch, which is a nonnegative integer holding the number of seconds that have elapsed since 00:00:00 UTC, Thursday, 1 January 1970.

Given an array, data, of data points, write a function findBusiestPeriod that returns the time at which the mall reached its busiest moment last year. The return value is the timestamp, e.g. 1480640292. Note that if there is more than one period with the same visitor peak, return the earliest one.

Assume that the array data is sorted in an ascending order by the timestamp. Explain your solution and analyze its time and space complexities.

Example:

input:  data = [ [1487799425, 14, 1],
                 [1487799425, 4,  0],
                 [1487799425, 2,  0],
                 [1487800378, 10, 1],
                 [1487801478, 18 0],,
                 [1487801478, 18, 1],
                 [1487901013, 1,  0],
                 [1487901211, 7,  1],
                 [1487901211, 7,  0] ]

output: 1487800378 # since the increase in the number of people
                   # in the mall is the highest at that point

 */