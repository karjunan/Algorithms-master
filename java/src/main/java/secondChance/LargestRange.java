package secondChance;

import java.util.HashMap;
import java.util.Map;

public class LargestRange {

    public static int[] largestRange(int[] array) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.computeIfAbsent(array[i], k -> false);
        }

        int max = Integer.MIN_VALUE;
        int[] result = new int[]{-1, -1};
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i])) {
                continue;
            }

            int left = array[i] - 1;
            int right = array[i] + 1;
            int counter = 0;

            while (map.containsKey(left) && !map.get(left)) {
                map.put(left, true);
                left = left - 1;
                counter++;

            }
            while (map.containsKey(right) && !map.get(right)) {
                map.put(right, true);
                right = right + 1;
                counter++;
            }

            if (counter > max) {
                max = counter;
                result[0] = left + 1;
                result[1] = right - 1;
            }

        }

        return result;
    }


}
