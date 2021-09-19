package secondChance;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeeSort {
    public static void main(String[] args) {
        int [] arr = {6,5,4,3,2,1};
        int [] temp = new int[arr.length];
        mergeSort(arr,temp,0,arr.length-1);
        System.out.println(Arrays.toString(temp));
    }

    public static void mergeSort(int [] arr, int[] temp, int left, int right) {

        if(temp.length < 2) {
            return;
        }
        int mid = (left+right)/2;

        int [] leftArr = new int[(mid - left)+1];
        int [] rightArr = new int[right - mid];

        for(int i = 0 ; i < leftArr.length; i++) {
            leftArr[i] = arr[left+i];
        }

        for(int i = 0 ; i < rightArr.length; i++) {
            rightArr[i] = arr[mid+i+1];
        }
        mergeSort(arr,leftArr,left,mid);
        mergeSort(arr,rightArr,mid+1,right);
        merge(temp,leftArr,rightArr);

    }

    private static void merge(int[] temp, int[] left, int[] right) {
        System.out.println("Left And right " + Arrays.toString(left) + " === " + Arrays.toString(right) );
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                temp[k] = left[i];
                i++;
            } else {
                temp[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < left.length) {
            temp[k] = left[i];
            k++;
            i++;
        }
        while(j < right.length) {
            temp[k] = right[j];
            k++;
            j++;
        }
        System.out.println("Temp Array " + Arrays.toString(temp));
    }
}
