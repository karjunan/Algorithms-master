package secondChance;

public class FindSubsets {

    public static void main(String[] args) {
        String str = "abcd";

        powerset(str, new StringBuffer(), 0);
    }

    private static void powerset(String str, StringBuffer stringBuffer, int idx) {
        System.out.println(stringBuffer.toString());
        if(idx == str.length()) {
            return;
        }

        stringBuffer.append(str.charAt(idx));
        powerset(str,stringBuffer,idx+1);
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        powerset(str,stringBuffer,idx+1);



    }
}
