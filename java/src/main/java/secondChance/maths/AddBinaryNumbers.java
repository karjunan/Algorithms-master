package secondChance.maths;

public class AddBinaryNumbers {

    public static void main(String[] args) {
        
        String str = "1111000";
        String str1 = "11111";
        System.out.println(addBinary(str,str1));
    }

    public static String addBinary(String a, String b) {

        int size = a.length() - b.length();
        if(size > 0) {
            b = appendZerosToTheBeginning(b, size);
        } else {
            a = appendZerosToTheBeginning(a, size * -1);
        }

        StringBuffer buffer = new StringBuffer();
        int carry = 0;
        for(int i = a.length()-1; i >= 0; i-- ) {

            int val = a.charAt(i)-'0' + b.charAt(i)-'0';
            val += carry;
            int r = val % 2;
            carry = val / 2;
            buffer.append(r);
        }

        if(carry !=0) {
            StringBuffer tmp = new StringBuffer();
            tmp.append(carry);
            tmp.reverse();
            buffer.append(tmp);
        }

        StringBuffer result = buffer.reverse();
        //System.out.println("Result is => " + result);
        return result.toString();

    }

    public static String appendZerosToTheBeginning(String str, int size) {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < size; i++) {
            buffer.append("0");
        }

        return buffer.append(str).toString();
    }
}
