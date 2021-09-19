package secondChance;

public class FindSubsets1 {

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3};
        subsets(0,arr,"");
    }

    public static void subsets(int idx, int [] arr, String result) {
        System.out.println(result);
        if(idx == arr.length) {
            System.out.println("Final result =>  " + result);
            return;
        }

        subsets(idx+1,arr,result+""+arr[idx]);
        subsets(idx+1,arr,result);
    }
}
