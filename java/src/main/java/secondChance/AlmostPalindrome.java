package secondChance;

import java.util.Arrays;

public class AlmostPalindrome {

    public static void main(String[] args) {
//        String str = "abccdba";
        String str = "raceacar";
//        String str = "abcdefdba";
//          String str = "abc";

          int [] cuts = new int[1];
          System.out.println("This is almost a palindrome => " + isAlmostPalindrome(str));
          boolean result = isAlmostPalindromeRecursion(str, str.length() % 2 == 0);
          System.out.println(" Trying out recurssion myself is almost palindrome  => " + result);
    }

    public static boolean isAlmostPalindromeRecursion(String str, boolean isEven) {
        System.out.println(str);
        int left = 0;
        int right = str.length()-1;
        if(left >= right){
            return false;
        }
        boolean leftNode = false;
        boolean rightNode = false;
        if(str.length() == 0) {
            return false;
        }

        if(str.charAt(left) == str.charAt(right)) {
            if(str.length() <= 2) {
                return true;
            }

            return isAlmostPalindromeRecursion(str.substring(left+1,right), isEven);
        } else {
            leftNode = isAlmostPalindromeRecursion(str.substring(left+1,right+1), isEven);
            rightNode = isAlmostPalindromeRecursion(str.substring(left,right), isEven);
        }

        return leftNode || rightNode;

    }

    public static boolean isAlmostPalindrome(String str) {
        Node result = isPalindrome(str);
        if(!result.isValid) {
            // Remove either of the string and try out the possiblities
            String removeLeft = str.substring(0,result.notMatchingPosition[0]) + str.substring(result.notMatchingPosition[0]+1,str.length());
            String removeRight = str.substring(0,result.notMatchingPosition[1]) + str.substring(result.notMatchingPosition[1]+1,str.length());
            Node leftResult = isPalindrome(removeLeft);
            Node rightResult = isPalindrome(removeRight);

            if(leftResult.isValid || rightResult.isValid) {
                return true;
            }
        }

        return false;
    }

    public static Node isPalindrome(String str) {
        int left = 0;
        int right =str.length()-1;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return new Node(false, new int[] {left,right});
            }
            left++;
            right--;
        }
        return new Node(true, new int[] {left,right});
    }

    static class Node1 {
        boolean isValid = false;
        int cuts = 0;

        public Node1(boolean isValid, int cuts) {
            this.isValid = isValid;
            this.cuts = cuts;
        }
    }
    static class Node {
        boolean isValid = false;
        int[] notMatchingPosition = new int[2];
        public Node(boolean isValid , int [] notMatchingPosition) {
            this.isValid = isValid;
            this.notMatchingPosition = notMatchingPosition;
        }
    }
}
