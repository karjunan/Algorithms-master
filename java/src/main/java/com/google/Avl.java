package com.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class Avl {

    static Node root = null;
    static Integer min = Integer.MAX_VALUE;
    public static void main(String[] args) {


        insert(1);
        insert(3);
        insert(2);
//        inOrderTraversal(root);
//        printFromlastlevel(root);
//        delete(root,8);
//        printFromlastlevel(root);
//        inOrderIterativeTraversal(root);
//
//        int data = search(root,13);
//        System.out.println("Data is available : => " + 6);
////        int val = height(root);
////        System.out.println("Height is " + val);
//        inOrderTraversal(root);
        preOrderTraversal(root);
//        int val = height(root);
////        inOrderTraversal(root);
//        System.out.println("Find All Paths -----------");
//        findAllPaths(root,new ArrayList<>());
//        System.out.println("Height is " + val);
        minimumDistance(root,0,root.data);
        System.out.println("Min Value is =>>>>> " + min);
    }


    public static int minimumDistance(Node node, int parent, int child) {

        if(node != null ) {
            System.out.println(node.data + " ===> " + parent + " ===> " + child);
        }
         System.out.println(" Node null -==>> "+  parent + " ===> " + child);
        if(node == null) {
            return child ;
        }

        int c = minimumDistance(node.left,child,node.data);
        System.out.println("Subtracting values" + c + " =>>>> " + child);
        min = Math.min(min,Math.abs(c- child));
        System.out.println("Minimum value = > " + min);
        int v = minimumDistance(node.right,child,node.data);
        return v;
    }

    public static void findAllPaths(Node node, List<Integer> list) {
        if(node == null) {
            System.out.println(list);
            return;
        }
        list.add(node.data);
        findAllPaths(node.left,list);
        findAllPaths(node.right,list);
        list.remove(list.size()-1);
    }

    public static int height(Node node) {
        if(node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left),height(node.right));
    }

    public static void insert(int data) {
        root = add(data, root);

    }

    public static int search(Node node, int data) {
        if(node == null) {
            return -1;
        }

        if(node.data == data) {
            return node.data;
        }

       return node.data < data ? search(node.right,data) : search(node.left, data);
    }



    public static List<Integer> preOrderTraversal(Node root) {
        Stack<Node> stack = new Stack();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.data);
            System.out.println(list);
            if(root != null && root.right != null ) {
                stack.push(root.right);
            }

            if(root != null && root.left != null) {
                stack.push(root.left);
            }

        }


        return list;
    }


    public List<Integer> inorderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty() && root != null) {

            if(root.left != null) {
                stack.push(root.left);
                root = root.left;
                continue;
            }

            Node con = stack.pop();
            list.add(con.data);
            if(con.right != null) {
                stack.push(con.right);
                root = con.right;
            }
        }
        return list;
    }

    public static void inOrderIterativeTraversal(Node node) {

        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if(node != null)
        {
            stack.push(node);
        }
        Node current = stack.peek();
        while(!stack.isEmpty()) {
            System.out.println(list);
            while(current.left != null ) {
                Node temp = current.left;
                stack.push(temp);
                current = current.left;
            }

            Node t = stack.pop();
            list.add(t.data);
            if(t.right != null) {
                Node temp = t.right;
                stack.push(temp);
                current = t.right;
            }
        }
        System.out.println(list);
    }

    public static void inOrderTraversal(Node node) {
        if(node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }

    public static Node add(int data, Node node) {
        if(node != null && data < node.data ){
            node.left = add(data,node.left);
        }else if(node != null && data > node.data) {
            node.right = add(data,node.right);
        } else {
            return new Node(data);
        }

        int balance = height(node.left) - height(node.right);

        if(balance < -1) {
            if(height(root.right.right) >= height(root.right.left)) {
                return rotateLeft(node);
            } else {
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
        }

        if(balance > 1) {
            if(height(root.left.left) >= height(root.left.right)) {
                return rotateRight(node);
            } else {
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }

        }
        return node;

    }

    public static Node rotateLeft(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left  = root;
        return temp;

    }

    public static Node rotateRight(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right  = root;
        return temp;

    }


    public static Node  delete(Node node, int data) {

        if(node == null) {
            return node;
        }

        if(data < node.data) {
            node.left = delete(node.left,data);
        } else if(data > node.data) {
            node.right = delete(node.right,data);
        } else {
            // Found the node to be deleted
            //case 1 : When the node had no children
            if(node.left == null && node.right == null) {
                node = null;
                return node;
            } else if(node.left == null && node.right != null) {
                Node temp = node.right;
                node = temp;
                return node;
            } else if(node.right == null && node.left != null) {
                Node temp = node.left;
                node = temp;
                return node;
            } else if(node.left != null && node.right != null) {
                Node minNode = findMin(node.right);
                delete(node,minNode.data);
                node.data = minNode.data;
            }
        }

        return node;
    }


    public static Node findMin(Node node) {
        if(node == null ) {
            return null;
        }
        Node temp = node;
        node.left = findMin(node.left);
        return temp;


    }

    public static void printFromlastlevel(Node node) {
        Queue<Node> queue1 = new LinkedBlockingQueue<>();
        queue1.add(node);
        List<List<Integer>> list = new ArrayList<>();
        while(!queue1.isEmpty()) {
            int s = queue1.size();
            List<Integer> templist =new ArrayList<>();
            while ( s > 0) {
                Node n = queue1.poll();
                templist.add(n.data);
                if(n.left != null ) {
                    queue1.add(n.left);
                }

                if(n.right != null) {
                    queue1.add(n.right);
                }
                s--;
            }
            list.add(templist);
            System.out.println("List content " + list);
        }
        int i = 0;
        int j = list.size()-1;
        while(i < j) {
            List<Integer> temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i++;
            j--;
        }
        System.out.println("List content " + list);
        List<Integer> fList = list.stream().flatMap(k-> k.stream()).collect(Collectors.toList());
        System.out.println(fList);
    }

    public static class Node {

        int data = 0;
        Node left = null;
        Node right = null;
        Node(int data) {
            this.data = data;
        }
    }

}
