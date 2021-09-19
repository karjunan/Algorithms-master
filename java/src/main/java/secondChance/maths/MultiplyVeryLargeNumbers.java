package secondChance.maths;

public class MultiplyVeryLargeNumbers {

    public static void main(String[] args) {
        String nums1 = "1213213";
        String nums2 = "342342342";

        String result = multiply(nums1,nums2);
        System.out.println(" The result is => " + result);
    }

    public static String multiply(String num1, String num2) {

        int [] temp = new int[num1.length() + num2.length()];

        for(int i = num1.length()-1; i >= 0; i--) {
            for(int j = num2.length()-1; j >= 0; j--) {
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int sum = temp[i + j + 1] + mul;
                temp[i+j] += sum/10;
                temp[i+j+1] = sum % 10;
                // System.out.println(Arrays.toString(temp));
            }
        }

        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < temp.length; i++) {
            if( buffer.length () != 0 || temp[i] != 0 ) {
                buffer.append(temp[i]);
            }

            //  System.out.println(buffer.toString());
        }

        return buffer.length() == 0 ? "0" : buffer.toString();
    }
}
