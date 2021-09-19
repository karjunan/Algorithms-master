package secondChance.bitManipulation;

public class FindNumberOfSetBits {

    public static void main(String[] args) {
        int val = 25;
        int val2 = val;
        int temp = 1;

        int counter = 0;

        while( val != 0) {
            if((val & temp) != 0) {
                counter++;
            }
            val = val >> 1;


        }

        System.out.println(" the total number of set bits are => " + counter);
        int counter1 = approach2(val2);
        System.out.println(" the total number of set bits using the second approach => " + counter1);

    }

    public static int approach2(int val) {

        int counter = 0;
        while(val != 0) {
            counter ++;
            val = val & (val - 1);
        }

        return counter;
    }
}
