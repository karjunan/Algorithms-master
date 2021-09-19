package secondChance;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DifferenceBetweenTwoStrings {

    public static void main(String[] args) {

        String source = "ABC";
        String target = "ABH";
        List<String> result = new ArrayList<>();
        // StringBuffer buffer = new StringBuffer();
        dfs(source, target, 0, 0, result, "");
        int min = Integer.MAX_VALUE;
        String str = "";
        for (int i = 0; i < result.size(); i++) {
            String[] str1 = result.get(i).split("-");
            String[] str2 = result.get(i).split("\\+");
            System.out.println(Arrays.toString(str1) + " == " + Arrays.toString(str2));
            int length = str1.length + str2.length;
            if (min > length) {
                min = length;
                str = result.get(i);
            }
        }
        System.out.println(str);
    }

    public static void dfs(String source, String target, int i, int j, List<String> result, String buffer) {
//AB-CD-EF+F+G+H
//AB-CD-EF+FG+H


        if (j == target.length()) {
            //System.out.println(buffer);
            result.add(buffer);
            return;
        }

        if (i >= source.length()) {
            return;
        }

        char sourceCh = source.charAt(i);
        char targetCh = target.charAt(j);

        if (source.charAt(i) == target.charAt(j)) {
            dfs(source, target, i + 1, j + 1, result, buffer + "" + source.charAt(i));
        }

        dfs(source, target, i + 1, j, result, buffer + "-" + sourceCh);
        dfs(source, target, i, j + 1, result, buffer + "+" + targetCh);

    }



}
