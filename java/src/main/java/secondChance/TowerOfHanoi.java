package secondChance;

public class TowerOfHanoi {

    public static void main(String[] args) {
        toh(4, 1,2,3);
    }

    public static void toh(int val, int A, int B, int C) {
        if(val >= 1) {
            toh(val - 1, A, C, B);
            System.out.println("Moving disk from => " + A + " - " + C);
            toh(val - 1, B, A, C);
        }
    }
}
