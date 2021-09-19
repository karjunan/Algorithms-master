package secondChance;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(fact(12));
        System.out.println(factNonRecursion(12));
    }

    public static int fact(int n) {
        if(n == 0) {
            return 1;
        }

        return fact(n-1) * n;
    }

    public static int factNonRecursion(int n) {
        int result = 1;
        for(int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
