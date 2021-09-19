package com.algorithms.algoExpert.easy;

public class LinkedList {

    static Node head;
    static Node tail;

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtBeginning(10);
        linkedList.insertAtBeginning(15);
        linkedList.insertAtBeginning(20);
        linkedList.insertAtBeginning(30);
        linkedList.insertAtBeginning(50);
        linkedList.insertAtEnd(5);
        linkedList.insertAtEnd(0);
//

        linkedList.iterate(head);

        linkedList.insertAfterANode(100 , new Node(10));
        linkedList.insertAfterANode(150, new Node(0));
        linkedList.insertAfterANode(150, new Node(50));
        linkedList.insertAfterANode(300, new Node(5));
        linkedList.iterate(head);

    }

    public static void insertAtBeginning(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            Node temp = head;
            node.next = temp;
            head = node;
        }

    }

    public void insertAfterANode(int data, Node node) {

        System.out.println(" ");
        Node prev = head;
        while(prev != null) {
            if(prev.data == node.data) {
                Node temp = prev.next;
                prev.next = null;
                prev.next = new Node(data);
                if(temp != null) {
                    prev.next.next = temp;
                    break;
                }

            }

            prev = prev.next;
        }
    }

    public static void insertAtEnd(int data) {
        Node node = new Node(data);
        if(tail == null) {
            head = node;
            tail = node;
        } else {
            Node temp = tail;
            temp.next = node;
            tail = node;
        }
    }

    public void iterate(Node node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
