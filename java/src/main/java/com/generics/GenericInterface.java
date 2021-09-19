package com.generics;

public class GenericInterface<E extends  Emp> {

    public void addEmployee(E e) {

        System.out.println(e);

    }

}
