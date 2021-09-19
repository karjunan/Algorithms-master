package secondChance;

public class FIndAllSubsetSums {

    public static void main(String[] args) {
        int [] arr = new int[] {1,2,3};
        int n = 6;
//        int total = subsetCount(n,0,arr, "");
//        System.out.println(" total subsets are => " + total);
        subset(n,0,arr, "");
    }


    public static int subsetCount(int val, int idx, int [] arr, String result) {
         System.out.println(" current val is  " + val);
        if(idx == arr.length || val < 0) {
            if(val == 0) {
                System.out.println(result);
                return 1;
            }
            return 0;
        }



        int right = subsetCount(val-arr[idx] , idx, arr, result+""+arr[idx]);

        int left =  subsetCount(val,idx+1,arr,result);

        return left+right;
    }


    public static void subset(int val, int idx, int [] arr, String result) {
        System.out.println(" current val is  " + val);
        if(idx == arr.length || val <= 0) {
            if(val == 0) {
                System.out.println(result);
                return;
            }
            return;
        }



        subset(val-arr[idx] , idx, arr, result+""+arr[idx]);
        subset(val,idx+1,arr,result);
    }
}
