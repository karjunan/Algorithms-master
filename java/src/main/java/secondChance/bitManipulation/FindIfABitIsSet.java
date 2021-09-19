package secondChance.bitManipulation;

public class FindIfABitIsSet {

    public static void main(String[] args) {

        int element = 12;
        int temp = 1;

        int isSet = 4;

        int shift = temp << isSet;

        //System.out.println(shift);

        int result = element & shift;

        if(result != 0) {
            System.out.println(" The bit has been set at the specific position");
        } else {
            System.out.println(" The bit has not been set at the given position");
        }
    }
}
