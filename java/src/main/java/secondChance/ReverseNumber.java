package secondChance;

public class ReverseNumber {

    public static void main(String[] args) {
        int val = 1233;

        int sum = 0;
        int temp = val;

        while(temp > 0) {
            int r = temp%10;
            sum = sum * 10+ r;
            temp = temp / 10;
        }

        System.out.println(val + " === " + sum);
    }
}
