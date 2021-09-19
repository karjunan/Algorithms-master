package secondChance.revision;

public class Factorial {

    public static void main(String[] args) {
        // n! = n * n-1 * n-2*
        // 3! = 3 * 2 * 1;

        System.out.println(fact(7));
        System.out.println(factIterative(7));
    }

    public static int factIterative(int n) {
        int fact = 1;
        for(int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        // 1 * 1 = 1;
        // 1 * 2 = 2;
        // 2 * 3 = 6;
        // 6 * 4 = 24
        // 24 * 5 = 120
        return fact;
    }

    public static int fact(int n) {

        if(n == 1) {
            return 1;
        }
        return n * fact(n-1);
    }
}
