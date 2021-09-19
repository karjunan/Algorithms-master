package secondChance;

public class ArmstrongNumber {
    public static void main(String[] args) {

        int v = 154;
        System.out.println(isArmstrong(v));
    }

    public static boolean isArmstrong(int n) {
        int temp = n;
        int sum = 0;
        while(temp > 0) {
            int r = temp % 10;
            r = r * r * r;
            sum += r;
            temp /= 10;
        }

        return sum == n;
    }
}
