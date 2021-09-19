package com.datastructures;

class CircularLinkedList {

    static Node root = null;
    static Node current = null;

    public static void main(String [] args) {
        add(1);
        add(13);
        add(20);
        add(30);
        printC(root);
    }


    public static void add(int data) {

         addI(data);
//        root = addR(data,root);
    }

    public static void addI(int data) {

        if(root == null) {
            root = new Node(data);
            current = root;
        } else {

            current.next = new Node(data);
            current = current.next;
        }

        current.next = root;

    }

    public static Node addR(int data,Node root) {

        if(root == null) {
            return new Node(data);
        }

        if(root.next == null) {
            root.next = new Node(data);
            return root;
        }

        Node cur = addR(data,root.next);
        return root;

    }


    public static void printC(Node root) {
        Node slow = root;
        Node fast = root;

        if(root.next == null) {
            System.out.println("Only one element present");
            return;
        }

        if(root.next.next == null ) {
            System.out.println("Not a circular List");
            return;
        } else {
            fast = root.next.next;
        }


        boolean bool = false;
        while(slow != null && fast !=null ) {

            System.out.println("slow: "+ slow.data + " :"+ fast.data);
            if(slow == fast) {
                System.out.println("slow and fast");
                bool = true;
                break;
            }

            if(slow.next != null) {
                slow = slow.next;
            } else {
                System.out.println("Not a circular list");
                return;
            }

            if(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                System.out.println("Not a circular list");
                return;
            }

        }

        if(bool) {
            System.out.println("Its circular list and the start node is :" + slow.next.data);
        }
    }


    public static void print(Node root) {
        Node temp = root;
        while(temp != null) {
            System.out.print(" " +temp.data);
            temp = temp.next;
        }

        System.out.println("\n");
    }

    public static class Node {

        Node next = null;

        int data;
        Node(int data) {
            this.data = data;
        }

    }
}
