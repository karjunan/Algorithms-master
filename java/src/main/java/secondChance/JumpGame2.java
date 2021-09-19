package secondChance;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame2 {


    public static void main(String[] args) {
        int [] nums = {8,2,4,4,4,9,5,2,5,4,6,8,9};

        System.out.println(jump(nums));

    }

    public static int jump(int[] nums) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);

        int counter  = 0;
        int length = nums.length-1;

        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int index = queue.poll();

                if(index > length) {
                    continue;
                }

                if(index == length){
                    return counter;
                }

                if(nums[index] == 0) {
                    continue;
                }

                int val = nums[index];
                int totalSize = val + index;
                for(int j = index + 1; j <= totalSize; j++) {
                    if(j > length) {
                        continue;
                    }
                    queue.add(j);
                }
            }

            counter++;

        }

        return counter;

    }
}
