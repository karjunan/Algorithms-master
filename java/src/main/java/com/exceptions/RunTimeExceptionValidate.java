package com.exceptions;

public class RunTimeExceptionValidate {

    public static void main(String[] args) {

        if(10 < 5) {
            throwRuntimeExcpetion();
        } else {
            throw new RuntimeException("Perfectly valid Excpetion");
        }


    }

    private static void throwRuntimeExcpetion() {

        throw new BusinessException("This is throwing a business Exceptions");
    }


}
