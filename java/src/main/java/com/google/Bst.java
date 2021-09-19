package com.google;

public class Bst {

    static Node root;
    static int maxValue = Integer.MIN_VALUE;
    public static void main(String[] args) {
        for(int i = 10 ; i < 16; i++) {
            add(i);
        }
        add(5);
        add(7);
        add(6);
        add(1);
        add(0);
//        add(4);
//        int val = postOrderTraversal(root);
//        System.out.println(maxValue);
//       Node n= lowestCommonAncestor(root,5,11);
        System.out.println( "lowest node is => " + findLowest(root.left.right).data);
    }

    public static Node findLowest(Node node) {
        if(node.left == null) {
            return node;
        }
        node = findLowest(node.left);
        return node;
    }

    public static Node lowestCommonAncestor(Node node, int l, int r) {
        if( node == null) {
            return null;
        }

        System.out.println("Node value is " + node.data);
        if(node.data == l || node.data == r) {
            return node;
        }
        Node left = lowestCommonAncestor(node.left,l,r);
        Node right = lowestCommonAncestor(node.right,l,r);

        if(left != null && right != null ) {
            System.out.println(left.data + " :::: " + right.data );
            return node;
        }

        return left != null ? left : right;



    }

    public static int postOrderTraversal(Node node) {
        if(node == null) {
            return 0 ;
        }

        int left = postOrderTraversal(node.left);
        int right = postOrderTraversal(node.right);
//        if(node.left == null && node.right == null) {
//            System.out.println(node.data + " :: " + node.data);
//        } else {
//        if(node.left == null && node.right != null) {
//            path = path + 1;
//        }
//        if(node.left != null && node.right == null) {
//            path = path + 1;
//        }
//        if(node.left != null && node.right != null) {
//            path = path + 1;
//        }
//      System.out.print("["+node.data+"]");
//        int max = Math.max(left,right);
        maxValue = Math.max(left,right)+1;
        return maxValue;
    }


    public static void add(int data) {
        if(root == null) {
            root = new Node(data);
            return;
        }
        root = add(root,data);
    }
    public static Node add(Node node, int data) {
        if(node == null) {
            return new Node(data);
        }

        if(data < node.data) {
            node.left = add(node.left, data);
        } else if(data > node.data) {
            node.right = add(node.right, data);
        }
        return node;
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}
