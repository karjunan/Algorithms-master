package com.algorithms.algoExpert;

public class BST {

//    public static Node root = null;
//    public static void main(String[] args) {
//
////        Random random = new Random();
//        // int [] arr = {10,5,15,2,5,13,22,1,12,14};
//        int [] arr = {10,11,15,22};
//        for(int i = 0 ; i < arr.length ; i++) {
//            add(arr[i]);
//        }
//
//         inOrder(root);
//         boolean bool = find(21);
//         System.out.println("\nElement found -> " + bool);
//         int min = findRightMin(root.right);
//         System.out.println("Min Value is " + min);
//        inOrder(root);
//        delete(10);
//        inOrder(root);
//    }

//    public static Node add(int value, Node root) {
//
//        root = addValue(value, root);
//
//    }

    public static Node add(int value, Node node) {
        if(node == null) {
            return new Node(value);
        } else if(value < node.value) {
            node.left = add(value,node.left);
        } else if(value > node.value) {
            node.right = add(value,node.right);
        }

        return node;
    }

//    public static boolean find(int value) {
//
//        return find(value,root);
//    }

    public static boolean find(int value, Node node) {
        boolean bool = false;
        if(node == null) {
            return bool;
        }

        if(node.value == value) {
            return true;
        } else if(value < node.value) {
            bool = find(value,node.left);
        } else if(value > node.value) {
            bool = find(value,node.right);
        }

        return bool;

    }

    public static int findRightMin(Node node) {
        if(node.left == null) {
            return node.value;
        }
        return findRightMin(node.left);
    }

    public static void delete(int value, Node root) {

        root = delete(value,root,null);

    }

    public static Node delete(int value, Node node,Node parent) {
        if(node == null) {
            return node;
        } else if(value < node.value) {
            node.left = delete(value,node.left,node);
        } else if(value > node.value) {
            node.right = delete(value,node.right,node);
        } else if(node.value == value) {
            System.out.println("Value found -> " + node.value);
            if(node.left == null && node.right == null) {
                if(parent.left != null && parent.left.value == node.value)
                {
                    parent.left = null;
                    return null;
                } else if(parent.right != null && parent.right.value == node.value)         {
                    parent.right = null;
                    return null;

                }
            } else if(node.left == null && node.right != null) {
                System.out.println("Removing root -> "+ node.value);
                Node temp = node.right;
                node = null;
                node = temp;
                System.out.println("After Removing root -> "+ node.value);
                return node;
            } else if(node.right == null && node.left != null) {
                node = node.left;
                return node;
            } else if(node.left != null && node.right != null) {
                int val = findRightMin(node.right);
                node.value = val;
                System.out.println("Node deleting -> " + val);
                delete(val,node.right,node);
            }
        }

        return node;
    }

    public static void inOrder(Node node) {
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

}
