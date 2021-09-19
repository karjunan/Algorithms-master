package com.algorithms.algoExpert;

import java.util.Stack;

public class BST1 {

    public static Node root = null;

//    public static void main(String[] args) {
//
//        add(100);
//        add(59);
//        add(150);
//        add(34);
//        add(67);
//        add(110);
//        add(157);
//        add(32);
//        add(69);
//        add(158);
//        inOrder(root);
//        remove(158);
//        System.out.println("------------------");
//        inorderRec();
//
//    }

    
    
    
    public static void inorderRec() {
        Stack<Node> stack = new Stack();
        stack.push(root);
        Node current = root;
        while(!stack.isEmpty() || current != null ) {

            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            //System.out.println(stack);
            current = stack.pop();
            System.out.println(current.value);
            current = current.right;
        }
    }

    public static void remove(int value) {
        remove(value,root, null);
    }

    public static Node remove(int value, Node root, Node parent) {
        if(root == null) {
            return null;
        }
        if(value < root.value) {
            root.left = remove(value,root.left,root);
        } else if(value > root.value) {
            root.right = remove(value, root.right,root);
        } else {
            // case 1 : where the node is the leaf
            if(root.left == null && root.right == null) {
                root = null;
            } else if(root.left == null && root.right != null) {
                root = root.right;
            } else if(root.right == null && root.left != null ) {
                root = root.left;
            } else if(root.left != null && root.right != null) {
                int rightMin = findMin(root.right);
                root.value = rightMin;
                root.right = remove(rightMin,root.right,root);
            } else {
                System.out.println(" You should never be here !! ");
            }
        }
        return root;
    }

    public static int findMin(Node root) {
        if(root.left == null) {
            return root.value;
        }
        return findMin(root.left);
    }

    public static void add(int value) {
         if(root == null) {
             root = new Node(value);
         } else {
             root = add(value,root);
         }
    }

    public static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public static Node add(int value, Node node) {
        if(node == null) {
            return new Node(value);
        } else if(value < node.value) {
            node.left = add(value,node.left);
        } else {
            node.right = add(value,node.right);
        }
        return node;
    }


    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
