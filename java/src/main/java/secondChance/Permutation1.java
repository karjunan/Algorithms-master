package secondChance;

import java.util.Arrays;

public class Permutation1 {

    public static void main(String[] args) {
        perm(new int[] {1,2,3},0);
    }

    public static void perm(int [] arr, int start) {
        System.out.println("IDX => " + start + " == " + Arrays.toString(arr));

        if(start == arr.length) {
            System.out.println("After final output =>> " + Arrays.toString(arr));
            return;
        }
        for(int i = start; i < arr.length; i++) {
            System.out.println( " IDX  and i value inside for loop =>> " + start + " == " + i);
            swap(arr,i,start);
            perm(arr,start + 1);
            swap(arr,i,start);
            System.out.println("Completed execution => " + start + " == " + i);
        }

    }
    public  static void swap(int [] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
