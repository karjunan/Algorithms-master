package secondChance;

import java.util.Arrays;

public class quickSort {

    public static void main(String[] args) {
//        int [] array = new int[] {4,3,2,1};
        int [] array = new int[] {2,4,1,3};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }

    public static void quickSort(int [] array, int left, int right) {
        if(left > right) {
            return;
        }

       int pIndex = partition(array,left, right);
        quickSort(array, left, pIndex-1);
        quickSort(array, pIndex+1, right);

    }

    public static int partition(int [] array, int left, int right) {

        int pIndex = left - 1;
        int pivot = array[right];

        for(int i = left; i < right; i++) {
            if(array[i] < pivot) {
                pIndex++;
                swap(array,i, pIndex);
            }
        }
        System.out.println(" Before Swap =>   " +Arrays.toString(array) + " === " +pIndex + " == " + right);
        swap(array, pIndex + 1, right);
        System.out.println(" After Swap =>   " +Arrays.toString(array) + " === " +pIndex + " == " + right);
        return pIndex + 1;
    }

    private static void swap(int[] array, int i, int pIndex) {
        int temp = array[i];
        array[i] = array[pIndex];
        array[pIndex] = temp;
    }
}
