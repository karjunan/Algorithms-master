package com.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {


    static Node root = null;
    public static void main(String [] arg){

       for(int i = 0 ; i < 10; i++) {
           add(i);
       }

        inOrder(root);
        System.out.println("\n");
        int res = max(root,Integer.MIN_VALUE);
        System.out.println("Max value " + res);

        int isPresent = 112;
        boolean bool = search(root,isPresent);
        System.out.println(isPresent + " is Present " + bool);

        isPresent = 1;
        bool = search(root,isPresent);
        System.out.println(isPresent + " is Present " + bool);

        System.out.println("\nTotal number of Nodes -> " + size(root));
//        heightWithoutRecurssion(root);
        inorderWithoutRecurssion(root);
    }

    public static void inorderWithoutRecurssion(Node node) {

        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean bool = false;
        Node currentNode = node;
        while(!bool) {

            if(currentNode != null) {
                stack.add(currentNode);
                currentNode = currentNode.left;
            } else {
                if(stack.isEmpty()) {
                    bool = true;
                } else {
                    Node current = stack.pop();
                    list.add(current.data);
                    currentNode = current.right;
                }
            }
            System.out.println(stack);

        }

        System.out.println(list);

    }

    public static int size(Node node) {
        if(node == null) {
            return 0;
        }

        int left = size(node.left);
        int right = size(node.right);
        System.out.print(left + " ");

        return (left + right) + 1;

    }

    public static void add(int data) {
        add(data,root);
    }


    public static void add(int data, Node node) {
        if(node == null) {
            root = new Node(data);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node newNode = new Node(data);
        while(!queue.isEmpty()) {

            Node n = queue.poll();

            if(n.left != null) {
                queue.add(n.left);
            } else if(n.left == null) {
                n.left = newNode;
                return;
            }

            if(n.right != null) {
                queue.add(n.right);
            } else if(n.right == null) {
                n.right = newNode;
                return;
            }
        }
    }

    public static int max(Node node,int data) {

        if(node == null) {
            return data;
        }

        int left = max(node.left,Math.max(node.data,data));
        int right = max(node.right,Math.max(node.data,data));

        return Math.max(left,right);

    }

    public static boolean search(Node node , int data) {
        if(node != null && node.data == data) {
            return true;
        }

        if(node == null) {
            return false;
        }

        if(search(node.left,data)){
            return true;
        }

        if(search(node.right,data)) {
            return true;
        }
        return false;
    }

    public static void inOrder(Node node) {
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);

    }

    public static void heightWithoutRecurssion(Node node) {
        java.util.Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            Node n = stack.peek();
            while(n.left != null) {
                stack.push(n.left);
                n = n.left;
            }
            System.out.println(" Popping out data" + stack.pop().data);
            System.out.println(stack.peek().data);
        }

    }

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        public String toString() {
            return Integer.toString(data);
        }
    }

}
