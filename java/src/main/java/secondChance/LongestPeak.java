package secondChance;

public class LongestPeak {

    public static void main(String[] args) {

    }

    public static int longestPeak(int[] array) {

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            int left = i;
            int right = i;
            boolean leftBool = false;
            boolean rightBool = false;
            while (left > 0 && array[left] > array[left - 1]) {
                leftBool = true;
                left--;
            }

            while (right < array.length - 1 && array[right] > array[right + 1]) {
                rightBool = true;
                right++;
            }
            if (leftBool && rightBool) {
                int result = right - left + 1;
                right = i;
                max = Integer.max(result, max);
            }

        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }


}
