package com.java8;

public enum Example {

    INDIA("Jai");

    private String value;

    Example(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
