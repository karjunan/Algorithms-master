package secondChance;

import java.util.Vector;

public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(" \nResult is =>  " + pascalsTriangle(1));
        System.out.println(pascal(74));
    }

    public static int pascalsTriangle(int n) {
            return helper(n,n);

    }

    public static int helper(int n, int r) {
        if(n == 0 || r == 0) {
            return 1;
        }

        int val = helper(n-1, r-1);
        int val1 = helper(n-1, r);
        System.out.print(val+val1 + "  ");
        return val + val1;
    }

    public static Vector<Long> pascal(int n) {
            long[][] arr = new long[n][n];

            arr[0][0] = 1;

            for(int i = 0; i < n; i++) {
                arr[i][0] = 1l;
            }

            for(int i = 0; i < n; i++) {
                arr[i][i] = 1l;
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < i; j++) {
                    if (i == j || j == 0) {
                        arr[i][j] = 1;
                        continue;
                    }

                    arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                }
            }

            //System.out.println(Arrays.deepToString(arr));
            Vector<Long> vector = new Vector<>();
            for(int i = 0; i < arr[0].length; i++) {
                vector.add(new Long(arr[n-1][i]));
                // System.out.println(vector);
            }
            return vector;
        }

}
