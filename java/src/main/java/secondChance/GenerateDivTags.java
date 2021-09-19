package secondChance;

import java.util.ArrayList;
import java.util.List;

public class GenerateDivTags {

    public static void main(String[] args) {

        ArrayList<String> result = generateDivTags(3);
        System.out.println(result);

    }

    public static ArrayList<String> generateDivTags(int numberOfTags) {
        // Write your code here.
        List<String> output = new ArrayList<>();
        dfs(numberOfTags, 0, 0, "", output);
        return new ArrayList<>(output);
    }

    public static void dfs(int numberOfTags, int i, int j, String result, List<String> output) {
        if(i > numberOfTags || j > i || j > numberOfTags) {
            return;
        }

        if(i == j && i == numberOfTags) {
            output.add(result);
        }

        dfs(numberOfTags, i+1, j, result+"<div>", output);
        dfs(numberOfTags, i , j+1, result+"</div>", output);

    }
}
