package secondChance;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(fib(11));
        System.out.println(fibNonRecurssive(11));
    }

    public static int fib(int n) {
        if(n < 2) {
                return n;
        }

        return fib(n-1) + fib(n-2);
    }

    public static int fibNonRecurssive(int n) {
        if(n < 2) {
            return n;
        }
        // 0 1 1 2 3 5 8 13 21
        // 0 1 2 3 4 5 6 7  8
        int first = 0;
        int second = 1;
        int result = 0;
        for(int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;

    }
}
