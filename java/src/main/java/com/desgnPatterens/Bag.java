package com.desgnPatterens;

import com.java8.CollectorIntStreamExample;

import java.util.ArrayList;
import java.util.List;

public class Bag<T extends Note> {

    List<T> list = new ArrayList<>();

    public void add(T t) {
        list.add(t);
    }

    public void display() {
        list.forEach(v -> System.out.println(v.val));
    }
}
