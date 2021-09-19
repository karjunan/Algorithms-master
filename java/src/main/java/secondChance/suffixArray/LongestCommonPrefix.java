package secondChance.suffixArray;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
//        String str = "ABRACADABRA";
        String str = "ABABBAABAA";
        String[][] strings = buildSuffixArray(str);
        computeLcp(strings);
        print(strings);
    }


    private static void computeLcp(String[][] strings ) {

        String prev = strings[0][2];
        for(int i = 1; i < strings.length; i++) {
            String current = strings[i][2];
            int prefixCount = getValidPrefixCount(prev, current);
            strings[i][1] = ""+prefixCount;
            prev = current;
        }

    }

    private static int getValidPrefixCount(String prev, String current) {
        int i = 0;
        int j = 0;
        int counter = 0;

        while(i < prev.length() && j < current.length()) {
            if(prev.charAt(i) != current.charAt(j)) {
                    return counter;
            }
            i++;
            j++;
            counter++;
        }

        return counter;
    }


    private static String[][] buildSuffixArray(String str) {
        String [][] splitString = new String[str.length()][3];
        int length = str.length() - 1;
        for(int i = 0; i < str.length(); i++) {
            splitString[i][0] = ""+(length-i);
            splitString[i][1] = ""+0;
            splitString[i][2] = str.substring(length - i, str.length());
        }
        print(splitString);

        Arrays.sort(splitString, (a, b) -> a[2].compareTo(b[2]));
        print(splitString);

        return splitString;
    }

    public static void print(String[][] string) {
        for(String[] str : string) {
            System.out.println(Arrays.toString(str));
        }
        System.out.println("");
    }
}
