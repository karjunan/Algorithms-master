package com.exceptions;

public class OverrideExceptiionsTest {

    public static void main(String[] args) {
        OverrideBaseExceptionValidate v = new OverrideBaseExceptionValidate();
        try {
            v.method1();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());

        }

    }
}
