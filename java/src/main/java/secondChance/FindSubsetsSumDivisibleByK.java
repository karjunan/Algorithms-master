package secondChance;

import com.sun.security.jgss.GSSUtil;

public class FindSubsetsSumDivisibleByK {

    public static void main(String[] args) {
        int [] arr = {4,3,2,9};
        int k = 3;
        //subsets(arr,0,k,"");
        int result = subset(arr,0,0,k);
        System.out.println(" How many subsets where there =>  " + result);
    }


    public static int subset(int [] arr, int idx, int sum, int k) {
        System.out.println(" Sum is => " + sum);
        if(idx == arr.length) {
            if(sum % k == 0 && sum != 0) {
                System.out.println(" This is a valid division => " + sum);
                return 1;
            }
            return 0;
        }

        int val1 = subset(arr,idx+1,sum+arr[idx],k);
        int val2 = subset(arr,idx+1,sum,k);

        return val1+val2;

    }

    public static void subsets(int [] arr, int idx, int k, String result) {
        System.out.println(result);
        if(idx == arr.length) {
            if(result.isEmpty()) {
                return;
            }
            String [] split = result.split("");
            int sum = 0;
            for(int i= 0; i < split.length; i++) {
                    sum += Character.getNumericValue(result.charAt(i));
            }
            if(sum % k == 0) {
                System.out.println("One possible solution is => " + result + " == " + sum);
            }
            return;
        }

        subsets(arr,idx+1,k,result+""+arr[idx]);
        subsets(arr,idx+1,k,result);

    }
}
