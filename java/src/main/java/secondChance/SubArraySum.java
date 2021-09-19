package secondChance;

import java.util.Arrays;

public class SubArraySum {

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,1,4,1,3,2,1,1,2};
        int target = 8;
        subArray(arr,target);
        subArrayPrefix(arr,target);
    }

    public static void subArrayPrefix (int [] array, int target) {
        int [] prefix = new int[array.length];
        prefix[0] = array[0];
        for(int i = 1; i < array.length; i++) {
            prefix[i] = prefix[i-1] + array[i];
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(prefix));
        for(int i = 0; i < prefix.length; i++) {
            int current = prefix[i];
            int toFind = current - target;
            int index = Arrays.binarySearch(prefix,toFind);
            if(index < 0 || toFind < 0) {
                continue;
            }
            int left = index + 1;
            System.out.println(" The indexes are => " + left + " == "+ i);
        }
    }

    public static void subArray(int[] arr, int target) {
        for(int i = 0 ; i < arr.length; i++) {
            int sum = 0;
            for(int j = i; j < arr.length; j++) {
                sum += arr[j];
                if(sum == target) {
                    System.out.println(" Target found => " + i + " == " + j + " === " + sum);
                    break;
                }
            }
        }
    }
}
