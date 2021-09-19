package com.datastructures;

import java.util.HashSet;
import java.util.NoSuchElementException;

public class LinkedList {

    static Node root ;
    static Node current;
    static int i;

    public static void main(String [] args) {

        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        print();
        reverseWithoutRecurssion(root);
        print();
//        reverseWithoutRecurssion(root);
//        print();
//        reverseInBlocks(root,3);
        print();
//        delete(2);
//        delete(2);
//        print();
//        rotate(5);

    }

    public static void reverseInBlocks(Node node , int pos) {

        int c = 0;

        Node head = null;
        Node reversed = null;
        Node temp = node;
        Node mCurrent = null;

        while(temp != null) {
            // print(temp);
            if(c != pos) {
                // System.out.println("C :: " + c);
                Node cur = temp.next;
                Node current = temp;
                current.next = null;
                current.next = reversed;
                reversed = current;
                temp = cur;
                c++;
            } else {
                System.out.println("Else ::");
                if(head == null) {
                    head = reversed;
                    Node t = head;
                    while(t.next != null) {
                        t = t.next;
                    }
                    mCurrent =  t;

                } else {
                    Node t = mCurrent;
                    while(t.next != null) {
                        t = t.next;
                    }
                    t.next = reversed;
                    mCurrent = t;
                }
                reversed = null;
                c = 0;
            }
        }

        Node t = mCurrent;
        while(t.next != null) {
            t = t.next;
        }

        t.next = reversed;
        root = head;
        print();
    }

    private static Node reverse(Node node) {
        if(node.next == null) {
            root = node;
            return node;
        }

        Node prev = reverse(node.next);
        prev.next = node;
        node.next = null;
        return node;
    }

    public static void reverseWithoutRecurssion(Node node) {

        Node reversed = node;
        Node temp = node.next;
        reversed.next = null;

        while(temp != null) {
            Node cur = temp.next;
            Node current = temp;
            current.next = null;
            current.next = reversed;
            reversed = current;
            temp = cur;
        }
        root = reversed;

    }

    private static void rotate(int val) {
        // 1 ,2 ,3 ,4
        // 3,4,1,2
        System.out.println(size());
        if(val < size()) {
            int current = 0;
            Node temp = root;
            Node previous;
            while(temp != null) {
                current++;
                temp = temp.next;
                previous = temp;
                if(val == current) {
                    temp = null;
                }

            }
        }


    }

    public static void add(int data) {
        Node node = new Node(data);
        if(root == null ) {
            root = node;
            current = root;
            i++;
        } else {
           current.next = node;
           current = current.next;
           i++;
        }
    }


    public static void delete(int data) {
        Node temp = root;
        if( null == root ) {
            throw new NoSuchElementException("List Empty");
        } else if(temp.data == data) {
            System.out.println("Root deleted:: " + temp.data);
            root = temp.next;
        } else {
            Node previous = temp;
            boolean bool = false;
            while(null != temp.next) {
                if(temp.next.data == data) {
                    bool = true;
                    System.out.println("Element to be delete is ::" + temp.next.data);
                    previous.next = temp.next.next;
                    i--;
                    break;
                }
                previous = previous.next;
                temp = temp.next;
            }

            if(!bool) {
                System.out.println("Element to be deleted not found : " + data);
            }
        }
    }

    public static void print() {
        Node temp = root;
        while(temp != null ) {
            System.out.print("["+temp.data+"]");
            temp = temp.next;
        }
        System.out.println("");
    }

    public static int size() {
        return i;
    }

    public static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }


    public static void duplicates(Node root) {
        HashSet<Integer> set = new HashSet<>();
        Node temp = root;
        Node previous = null;
        while(temp != null && temp.next != null ) {
            if(set.contains(temp.data)) {
                Node t = previous.next.next;
                Node t1 = previous;
                t1.next = null;
                t1 = t;
            } else {
                set.add(temp.data);

            }
            previous =  temp;
            temp = temp.next;
        }

    }

}
