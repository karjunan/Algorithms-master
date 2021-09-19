package secondChance.maths;

public class LeftShiftOperation {

    public static void main(String[] args) {
        int N = 4;
        int i = 3;
        // Left shift will result in  N * (2 pow i)
        // Imagine, if you had a Decimal number 5 4 3 2
        /*
                5432 << 1
                = 4320 ( what this means is 432 * 10 pow 1, which means 432 * 10 = 4320

                in similar terms
                5432 << 2
                 = 3200   = 32 * 10 pow 2 = 32 * 100 = 3200

                 The pattern above which is for decimal numbers needs to be applied for Binary numbers
         */
        System.out.println(N << i);
    }
}
