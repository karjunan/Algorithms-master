package com.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person());
        personList.add(new Employee());

    }

    public static Employee putElement(List<Person> person) {

            return (Employee) person.get(1);


    }
}
