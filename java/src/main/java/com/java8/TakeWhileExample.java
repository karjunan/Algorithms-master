package com.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TakeWhileExample {

    public static void main(String[] args) {

        Emp emp = new Emp("krishna","1");
        Emp emp1 = new Emp("rohith","2");
        Emp emp2 = new Emp("nanda","2");
        Emp emp3 = new Emp("prasanth","4");

        List<Emp> list = new ArrayList<>();
        list.add(emp);
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);



        List<Emp> takeWhileList = list.stream()
                .takeWhile(v -> (v.getId().equals("1")))
                .collect(Collectors.toList());


        List<Emp> dropWhileList = list.stream()
                .dropWhile(v -> (v.getId().equals("1")))
                .collect(Collectors.toList());


        System.out.println(takeWhileList);

        System.out.println("--------------------");
        System.out.println(dropWhileList);

        System.out.println("---------Final List -----------");
        List<List<Emp>> ls = list.stream()
                .map(v -> {
                     return list.stream().sorted(Comparator.comparing(Emp::getId))
                            .dropWhile(x -> x.getId().equals(v.getId())).collect(Collectors.toList());

                    } )
                .filter(v-> v.size() > 1 )
                .collect(Collectors.toList());

        ls.stream().forEach(System.out::println);

    }

    static class Emp  {
        String name;
        String id;

        public Emp(String name, String id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }
    }
}
