package secondChance;

public class SingleCycleCheck {

    public static void main(String[] args) {
        int [] arr = {2, 3, 1, -4, -4, 2};
        boolean result = hasSingleCycle(arr);

        System.out.println(" Is there a single Cycle => " + result);
    }

    public static boolean hasSingleCycle(int [] arr) {
        int counter = 0;
        int currentIDX = 0;

        while(counter < arr.length) {

            if(counter > 0 && currentIDX == 0) {
                return false;
            }

            int nextIDX = getNextIDX(currentIDX, arr);
            currentIDX = nextIDX;
            counter++;
        }

        return currentIDX == 0;
    }

    private static int getNextIDX(int currentIDX, int[] arr) {
        int nextIDX = currentIDX + arr[currentIDX];
        nextIDX = nextIDX % arr.length;
        if(nextIDX >= 0) {
            return nextIDX;
        }

        return nextIDX + arr.length;

    }

}
