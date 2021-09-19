package secondChance.revision;

public class TowerOfHanoi {

    public static void main(String[] args) {
        toh("S", "A", "E", 3);
    }

    public static void toh(String start, String auxillary , String end, int n) {

        if(n <= 0) {
            return;
        }

        toh(start, end, auxillary, n-1);
        System.out.println("Moving the Peg  from => " + start + " == " + end);
        toh(auxillary,start,end,n-1);
    }
}
