package com.test.emp;

import java.util.ArrayList;
import java.util.List;

public class Employee{


    public List<? extends Person> readColl() {

        return new ArrayList<>();
    }

    public void saveColl(List<? super Person> p) {

    }
}
