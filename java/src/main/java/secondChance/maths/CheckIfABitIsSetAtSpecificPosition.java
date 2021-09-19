package secondChance.maths;

public class CheckIfABitIsSetAtSpecificPosition {

    public static void main(String[] args) {
        int val = 75;
        int position = 2;
        System.out.println("IS the value set to one => " + isSetToOne(val,position));
    }

    public static boolean isSetToOne(int val, int position) {
        int f = 1;
        f = f << position;

        int temp = val & f;

        return temp == f;
    }
}
