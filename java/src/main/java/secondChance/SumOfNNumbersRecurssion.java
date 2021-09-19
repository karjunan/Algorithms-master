package secondChance;

public class SumOfNNumbersRecurssion {

    public static void main(String[] args) {

        System.out.println(add(10));
        System.out.println(addNonRecurssive(10));
    }

    public static int add( int n) {
        if(n == 0) {
            return 0;
        }

        return add(n-1) + n;
    }

    public static int addNonRecurssive( int n) {

        return (n * (n+1))/2;
    }
}
