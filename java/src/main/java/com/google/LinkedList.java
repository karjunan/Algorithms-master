package com.google;

public class LinkedList {

    static Node head = null;
    public static void main(String[] args) {

        add(1);
        add(2);
        add(3);
        print(head);
        Node n = delete(3);
        System.out.println("Deleted value =>" + n.val);
        print(head);
        addBeginning(21,head);
        addBeginning(22,head);

        print(head);
    }

    public static void add(int val ) {
        if(head == null) {
            head = new Node(val);
        } else {
            Node temp = head;
            while(temp.next != null ) {
                temp = temp.next;
            }
            Node node = new Node(val);
            temp.next = node;
        }
    }

    public static  Node delete(int val) {
        Node temp = head;
        Node prev = null;
        Node t = null;
        while(temp != null) {
            if(temp.val == val) {
                t = prev.next;
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }
        print(head);
        return t;
    }

    public static void addBeginning(int val , Node node) {
        Node temp = node;
        Node n = new Node(val);
        n.next = temp;
        head =n;

    }

    public static void print(Node head) {
        System.out.println("\n");
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static class Node {
        int val;
        Node next;
        Node(int val ){
            this.val = val;
        }
    }
}
