package secondChance;

public class RootOfANumber {

    public static void main(String[] args) {
            double result = root(10,3);
            double result1 = bsRoot(10,3);

        System.out.println(result + " ==== " + result1);
    }


    static double bsRoot(double x, int n) {

        if(x == 0) {
            return 0;
        }

        double lowerBound = 0;
        double upperBound = Integer.MAX_VALUE;

        double approxRoot = (lowerBound + upperBound ) /2;

        while(approxRoot - lowerBound >= 0.001) {
            System.out.println(approxRoot);
            if( Math.pow(approxRoot, n) > x) {
                upperBound = approxRoot;
            } else if( Math.pow(approxRoot, n) < x) {
                lowerBound = approxRoot;
            } else {
                break;
            }
            approxRoot = (upperBound + lowerBound)/2;
        }

        return approxRoot;
    }


    static double root(double x, int n) {


        int i = 1;
        for(; i < x; i++) {
            int result = 1;
            for(int j = 0; j < n; j++) {
                result *= i;
            }

            if(result > x) {
                break;
            }
        }

        double start = i-1;
        double end = i;
        double increment = 0.001f;
        while(start < end) {

            start = start + increment;
            double root = 1.000f;
            for(int j = 0; j < n; j++) {
                root *= start;
            }
          //  System.out.println(start + " === " + root);
            if(root - x > 0.001) {
                System.out.println("Result is ====> " + root + " === " + start);
                return start;
            }
        }
        return start;
    }
}

/*

Root of Number
Many times, we need to re-implement basic functions without using any standard library functions already implemented. For example, when designing a chip that requires very little memory space.

In this question we’ll implement a function root that calculates the n’th root of a number. The function takes a nonnegative number x and a positive integer n, and returns the positive n’th root of x within an error of 0.001 (i.e. suppose the real root is y, then the error is: |y-root(x,n)| and must satisfy |y-root(x,n)| < 0.001).

Don’t be intimidated by the question. While there are many algorithms to calculate roots that require prior knowledge in numerical analysis (some of them are mentioned here), there is also an elementary method which doesn’t require more than guessing-and-checking. Try to think more in terms of the latter.

Make sure your algorithm is efficient, and analyze its time and space complexities.

Examples:

input:  x = 7, n = 3
output: 1.913

input:  x = 9, n = 2
output: 3
Constraints:

[time limit] 5000ms

[input] float x

0 ≤ x
[input] integer n

0 < n
[output] float
 */