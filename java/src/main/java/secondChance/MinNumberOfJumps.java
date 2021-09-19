package secondChance;

public class MinNumberOfJumps {

    public static void main(String[] args) {
        int [] arr = {3,4,2,1,2,3,7,1,1,1,3};
        int result = jumps(0, arr, arr.length);

        System.out.println(" Min number of jumps needed is => "+ result);

    }

    public static int jumps(int start, int [] arr, int length ) {

        if(start >= length) {
            return Integer.MAX_VALUE;
        }

        if(start == length-1) {
            return 0;
        }

        int size = arr[start];
        int min = Integer.MAX_VALUE;

        for(int i = 1; i <= size; i++) {
            min = Math.min(min, jumps(i+start, arr, length));
        }

        return min + 1;

    }


}
