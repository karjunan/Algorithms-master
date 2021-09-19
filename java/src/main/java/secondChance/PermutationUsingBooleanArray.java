package secondChance;

import java.util.Arrays;

public class PermutationUsingBooleanArray {

    public static void main(String[] args) {
        String str = "abc";
        boolean[] bool = new boolean[str.length()];
        char [] ch = new char[str.length()];
        perm(str,bool,ch,0);

    }

    public static void perm(String str, boolean[] bool, char[] result, int idx) {
        System.out.println(Arrays.toString(result) + "  ===  " + Arrays.toString(bool));
        if(idx == str.length()) {

            return;
        }

        for(int i = 0; i < bool.length; i++) {
            System.out.println(" IDX and I " + idx + " === " + i);
            if(bool[i]) {
                continue;
            }
            result[idx] = str.charAt(i);
            bool[i] = true;
            perm(str,bool,result, idx + 1);
            bool[i] = false;
        }

    }
}
