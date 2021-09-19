package com.exceptions;

public class OverrideExceptionValidate extends OverrideBaseExceptionValidate {

    @Override
    public void method1() throws Exception {
        int i = Integer.parseInt("krisn");
        System.out.println("Over riding method");
    }
}
