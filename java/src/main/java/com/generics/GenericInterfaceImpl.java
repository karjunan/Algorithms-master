package com.generics;

public class GenericInterfaceImpl {

    public static void main(String[] args) {
        GenericInterface<Emp> genericInterface = new GenericInterface<>();
        genericInterface.addEmployee(new SalesEmployee());
    }
}
