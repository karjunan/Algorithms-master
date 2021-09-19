package com.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class DoublyLinkedList {

    static Node root = null;
    static Node current = null;

    static int [] arr = {1,22,3,4};
    public static void main(String[] ar) {


        IntStream.of(arr).forEach(v -> System.out.print(" " +v));

        String str = "bbb";
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i< str.length(); i++) {
            map.compute(str.charAt(i), (k,v) -> v != null ? v+1 : 1);
        }

        System.out.println(map.getOrDefault('a',0));

        add(10);
        add(1);
        add(23);
        add(3);
        add(5);
        print("", root);
        System.out.println("");
//        rprint(" ", current);

        reverse();
        print("",root);

        delete(10);
        print("", root);

        delete(23);
        print("", root);


        delete(5);
        print("", root);

        delete(3);
        print("", root);


        delete(1);
        print("", root);

        delete(10);

    }

    public static Node reverse() {
        root =  reverse(root,null);
        return root;
    }

    public static Node reverse(Node node, Node var) {

        if (node.next == null) {
            return node;
        }

        var = reverse(node.next,var);
        node.next.next = node;
        node.prev = node.next;
        node.next = null;
        return var;
    }


    public static void delete(int data) {

        delete(root, data);

    }


    public static void delete(Node node, int data) {

        Node temp = node;
        Node previous = null;
        boolean bool = false;
        if (temp == null) {
            System.out.println("List is Empty");
            return;
        }
        if (temp.next == null) {
            if(temp.data == data) {
                //Delete first not when there is only one element
                root = null;
                return;
            }

        }  else if(temp.next != null) {
            if(temp.data == data) {
                //Delete first not when there are other element
                Node t = temp.next;
                root = null;
                root = t;
                return;
            }
        }

        while (temp != null) {
            if (temp.data == data) {
                if (temp.next != null) {
                    Node cur = temp.next;
                    //Delete any mid node
                    temp.next = null;
                    temp.prev = null;
                    previous.next = cur;
                    cur.prev = previous;
                } else {
                    //delete last node;
                    previous.next = null;
                }
                bool = true;
                break;
            }
            previous = temp;
            temp = temp.next;
        }

        if (!bool) {
            System.out.println("No data found");
        }


    }

    public static void add(int data) {
        root = addR(data,root);
//        addI(data);
    }

    public static Node addR(int data, Node node) {

        if(node == null ) {
            return new Node(data);

        }
        Node cur = addR(data,node.next);
        node.next = cur;
        cur.prev = node;
        return node;

    }


    public static void addI(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
            current = root;
        } else {
            current.next = node;
            node.prev = current;
            current = current.next;
        }

    }

    public static void print(String msg, Node node) {

        Node temp = node;
        System.out.println(msg);
        if (temp == null) {
            System.out.println("No element to Iterate");
        }
        while (temp != null) {
            System.out.print("  " + temp.data);
            temp = temp.next;
        }
        System.out.print("\n");


    }

    public static void rprint(String msg, Node node) {

        Node temp = node;
        System.out.println(msg);
        while (temp != null) {
            System.out.print("  " + temp.data);
            temp = temp.prev;
        }
        System.out.print("\n");


    }


    public static class Node {

        Node next = null;
        Node prev = null;

        int data;

        Node(int data) {
            this.data = data;
        }

    }
}
