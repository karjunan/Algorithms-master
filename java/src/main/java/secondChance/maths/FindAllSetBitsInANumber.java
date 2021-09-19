package secondChance.maths;

public class FindAllSetBitsInANumber {

    public static void main(String[] args) {
        int num = 211;
        System.out.println("The number of set bits are ==> " + findSetBitsUsingTheLSBAndUsingAnAdditionVariable(num));
        System.out.println("The number of set bits are using alternate Approach==> " + findSetBitsUsingAlternateApproachByExploitingLSBfeature(num));

    }

    public static int findSetBitsUsingAlternateApproachByExploitingLSBfeature(int nums) {

        int temp = nums;
        int counter = 0;
        while(temp > 0) {
            counter++;
            // This set will remove the LSB on each iteration. So its little bit more efficient
            // comparing to the other approach
            temp = temp & (temp - 1);
        }
        return counter;
    }

    public static int findSetBitsUsingTheLSBAndUsingAnAdditionVariable(int nums) {

        int temp = nums;
        int counter = 0;
        int f = 1;
        while(temp > 0) {
            int result = temp & f;
            if(result == f) {
                counter++;
            }
            temp  = temp >> 1;

            System.out.println(temp);
        }
        return counter;
    }
}
