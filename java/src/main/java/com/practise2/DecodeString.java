package com.practise2;

public class DecodeString {

    public static void main(String[] args) {

        String str = "112311111115";
        char [] ch = new char[27];
        int val = 'A';
        for(int i = 1 ; i < ch.length; i++) {
            ch[i] = (char)val++;
        }
        int [] arr = new int[str.length()+1];
        int result = helper(str,0, arr);
        System.out.println("Result is => " + result);

    }

    public static int helper(String str, int val, int [] arr) {
        if(str.length() == val) {
            return 1;
        }

        if(str.charAt(val) == '0') {
            return 0;
        }

        if(val == str.length()-1) {
            return 1;
        }

        if(arr[val] > 0) {
            return arr[val];
        }
        int way1 = helper(str,val+1,arr);

        int way2 = 0;

        if(Integer.parseInt(str.substring(val,val+2)) <= 26) {
            way2 = helper(str,val+2, arr);
        }
        arr[val] = way1 + way2;
        return arr[val];


    }
}
