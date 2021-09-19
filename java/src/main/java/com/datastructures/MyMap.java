package com.datastructures;

import java.util.LinkedList;

class MyMap {

    static Node [] arr = new Node[20];

    public static void main(String[] args) {

        put("krishna","k");
        put("Ram", "r");
        put("Sam", "str");
        put("krishna","k1");
        put("Sam", "str1");

        print();
        System.out.println("Value is : " + get("s"));


    }



    public static String get(String key) {
        int n = hashcode(key);
        int val = n % arr.length;

        Node node = arr[val];
        String result = null;
        if(node != null && node.linkedList != null) {
            for( int i = 0 ; i < node.linkedList.size(); i++ ) {
                if(node.linkedList.get(i).key.equals(key)) {
                    return node.linkedList.get(i).value;
                }
            }
        }
        return null;

    }

    public static void put(String key , String value) {

        int val = hashcode(key);
        int pos = val % arr.length;
        Data data = new Data();
        data.key = key;
        data.value = value;

        System.out.println("Position :: " + pos);
        Node node = null;
        if(arr[pos] == null) {
            node = new Node();
            java.util.LinkedList lk = new LinkedList();
            lk.addLast(data);
            node.linkedList = lk;
        } else {
            node = arr[pos];
            boolean bool = false;
            for( int i = 0 ; i < node.linkedList.size(); i++) {
                if(node.linkedList.get(i).key.equals(key)){
                    node.linkedList.get(i).value = value;
                    bool = true;
                    break;
                }
            }

            if(!bool) {
                node.linkedList.addLast(data);
            }
        }

        arr[pos] = node;
    }

    public static void print() {
        for( int i = 0 ; i < arr.length; i++) {
            if(arr[i] != null) {
                arr[i].linkedList.stream().forEach(v -> System.out.println(v));
            }
        }
    }

    public static int hashcode(String key ) {

        int hash = 0;

        for( int i = 0 ; i < key.length(); i++) {

            hash = hash +(int)key.charAt(i);
        }

        return hash;
    }


    static class Node {

        java.util.LinkedList<Data> linkedList ;


    }

    static class Data {
        public String key;
        public String value;

    }



}
