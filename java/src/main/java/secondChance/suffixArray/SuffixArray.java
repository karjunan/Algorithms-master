package secondChance.suffixArray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SuffixArray {

    public static void main(String[] args) {

        String str = "AZAZA";
        buildSuffixArray(str);
    }

    private static void buildSuffixArray(String str) {
        String [][] splitString = new String[str.length()][2];
        int length = str.length() - 1;
        for(int i = 0; i < str.length(); i++) {
            splitString[i][0] = ""+(length-i);
            splitString[i][1] = str.substring(length - i, str.length());
        }
        print(splitString);

        Arrays.sort(splitString, (a,b) -> a[1].compareTo(b[1]));
        print(splitString);
    }

    public static void print(String[][] string) {
        for(String[] str : string) {
            System.out.println(Arrays.toString(str));
        }
        System.out.println("");
    }

    /*
         str = "AZAZA"
         k = 5
         i = 0 k = 5  =  k -1 - i =  4 - 0 = 4 , 5;
         i = 1 k = 5  = k - i = 3,5;
         i = 2, k = 5 = k - i = 2,5
         i = 3, k = 5 , k - i = 1, 5
         i = 4, k = 5 , k - i = 0, 5

     */
}
