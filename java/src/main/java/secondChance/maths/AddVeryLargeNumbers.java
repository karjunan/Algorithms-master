package secondChance.maths;

import java.math.BigInteger;

public class AddVeryLargeNumbers {

    public static void main(String[] args) {

        String num1 = "11239798798798798798";
        String num2 = "7787897987987987987987979879879";
        String result = add(num1,num2);
        BigInteger in = new BigInteger(num1).add(new BigInteger(num2));
        System.out.println(" Sum is => " + result + " === " + in);
    }

    public static String add(String num1, String num2) {
        int size = num1.length() - num2.length();
        if(size > 0) {
            num2 = appendZerosToTheBeginning(num2,size);
        } else {
            num1 = appendZerosToTheBeginning(num1,size * -1);
        }

        System.out.println(num1);
        System.out.println(num2);
        StringBuffer buffer = new StringBuffer();
        int carry = 0;
        for(int i = num1.length()-1 ; i >= 0; i--) {
            int val = num1.charAt(i) - '0' + num2.charAt(i)-'0';
            val += carry;
            carry = val / 10;
            buffer.append(val%10);
        }
        if(carry != 0) {
            StringBuffer buf = new StringBuffer();
            buf.append(carry);
            buf.reverse();
            buffer.append(buf);
        }

        String res = buffer.reverse().toString();
        //System.out.println(res);
        return res;
    }

    public static String appendZerosToTheBeginning(String num, int size) {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < size; i++) {
                buffer.append("0");
        }

        return buffer.append(num).toString();
    }
}
