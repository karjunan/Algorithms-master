package com.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class BinaryTree {


    public static void main(String[] args) {

        Node root = null;
        Node root1 = null;
        BinaryTree bt = new BinaryTree();
//        BinaryTree bt1 = new BinaryTree();

        for( int i = 1 ; i < 5; i++) {
              root = insertWithParameter(i,root);
           }
        Random random = new Random(0);
        for( int i = 1 ; i <= 16; i++) {
            root1 = insertWithParameter(i,root1);
        }


        System.out.println("\nRoot 1 --------------- ");
        inOrderTraversal(root1);

        System.out.println("\nAre these equal => " + areTwoTreesEqual(root,root1));
        System.out.println("\nAre these equal => " + areTwoTreesEqualIterative(root,root1));

        System.out.println("\nHeight of first root => " + height(root));
        System.out.println("\nHeight of Second root1 => " + height(root1));
        heightLevelOrder(root1);
        spiralTraversal(root1);
        printFromlastlevel(root1);
        printNodesInSpecificOrder(root1);
        bfsLevelAverage(root);

//        findAllPaths(root1,new ArrayList<>(),new ArrayList<>());
        inOrderTraversal(root1);
        Node n = find(root1,100);
        if(n != null)
            System.out.println(" Found Node => " + n.data);
        else
            System.out.println("Element not found !! ");

    }
    static boolean bool = false;
    public static Node find(Node node, int val) {
        if(node == null) {
            return null;
        }

        Node temp = null;
        if(node.data == val) {
            System.out.println("Data found initially itself=> " + node.data + " => " + val);
            bool = true;
            return node;
        }

        if(!bool) {
            temp = find(node.left, val);
        }

        if(!bool) {
           temp = find(node.right, val);
        }

        System.out.println("Returning Node " + node.data);
      return temp;
    }
    public static void findAllPaths(Node node, List<Integer> list,
                                    List<List<Integer>> totalPaths) {
        if(node == null) {
             return;
        }

        list.add(node.data);
        if(node.left == null && node.right == null) {
            System.out.println("List => " + list);
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < list.size(); i++ ) {
                map.compute(list.get(i), (key,val) -> val == null ? 1: val+1);
            }
            int counter = 0;
            for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
                if(entry.getValue() % 2 != 0) {
                    counter++;
                }
                if(counter > 1) {
                    return;
                }
            }
            totalPaths.add(new ArrayList<>(list));
            System.out.println("Total paths => " + totalPaths);
        }
        findAllPaths(node.left,list,totalPaths);
        findAllPaths(node.right,list,totalPaths);
        list.remove(list.size()-1);
    }


    public static void bfsLevelAverage(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        List<Double> list = new ArrayList<>();
        list.add(Double.valueOf(node.data));
        while(!queue.isEmpty()) {
            int size = queue.size();
            int val = 0;
            for(int i = 0; i < size;i++) {
                Node n = queue.poll();
                if(n.left != null) {
                    queue.add(n.left);
                    val = val + n.left.data;
                }
                if(n.right != null) {
                    queue.add(n.right);
                    val = val + n.right.data;
                }
            }
            list.add(Double.valueOf(val/size));
        System.out.println(list);
        }
        System.out.println("Final output =>"+ list);
    }


    public static void printNodesInSpecificOrder(Node node) {
        List<Integer> post = new ArrayList<>();
        inOrdertraversal(node,post);
        System.out.println(post);
        int i = 0;
        int j = post.size()-1;
//        List<Integer> newList = new ArrayList<>();
        node = null;
        for(Integer val: post) {
            node = insertWithParameter(val,node);
        }
        inOrderTraversal(node);

//        while(i <= j) {
//            newList.add(post.get(i));
//            newList.add(post.get(j));
//            i = i+2;
//            j = j-2;
//        }
//        i = 1;
//        j = post.size()-2;
//
//        while(i <= j) {
//            newList.add(post.get(i));
//            newList.add(post.get(j));
//            i = i+2;
//            j = j-2;
//        }
//        System.out.println("Final List => " + newList);
    }
    public static void inOrdertraversal(Node node, List<Integer> list) {
        if(node == null){
            return;
        }

        inOrdertraversal(node.left,list);
        inOrdertraversal(node.right,list);
        list.add(node.data);


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

    public static void spiralTraversal(Node node) {
        Queue<Node> queue1 = new LinkedBlockingQueue<>();
        queue1.add(node);
        int size = 0;
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = null;
        while(!queue1.isEmpty()) {
            int s = queue1.size();
            size++;
            stack = new Stack<>();
            while ( s > 0) {
                Node n = queue1.poll();
                if(size % 2 != 0 ){

                    stack.push(n.data);
                } else {
                    list.add(n.data);
                }

                if(n.left != null ) {
                    queue1.add(n.left);
                }

                if(n.right != null) {
                    queue1.add(n.right);
                }
                s--;
            }
            while(!stack.isEmpty()) {
                Integer val = stack.pop();
                list.add(val);
            }
            System.out.println("Height is => " + list);
        }

    }

    public static void heightLevelOrder(Node node) {
        Queue<Node> queue1 = new LinkedBlockingQueue<>();
        Queue<Node> queue2 = new LinkedBlockingQueue<>();

        queue1.add(node);
        int count = 0;
        while(true) {

            if(!queue1.isEmpty()) {
                count++;
            }
            while(!queue1.isEmpty()) {
                Node n = queue1.poll();
                if(n.left != null) {
                    queue2.add(n.left);
                }

                if(n.right != null) {
                    queue2.add(n.right);
                }
            }
            if(!queue2.isEmpty()) {
                count++;
            }
            while(!queue2.isEmpty()) {
                Node n = queue2.poll();
                if(n.left != null) {
                    queue1.add(n.left);
                }

                if(n.right != null) {
                    queue1.add(n.right);
                }
            }
            if(queue1.isEmpty() && queue2.isEmpty()) {
                break;
            }
        }
        System.out.println("Total height is => "+ count);
    }

    public static int height(Node node) {
        if(node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left),height(node.right));
    }

    public static  void inOrderTraversal(Node node) {
        if(node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print("["+node.data+"]");
        inOrderTraversal(node.right);
    }


    public static Node insertWithParameter(int data, Node node) {
        if(node == null ) {
            return new Node(data);
        } else {
            add(data,node);
        }
        return node;
    }
    public static void add( int data, Node n) {
            Queue<Node> queue = new LinkedBlockingQueue<>();
            queue.add (n);
            while(!queue.isEmpty()) {
                Node node = queue.poll();
               // System.out.println("Emptying queue => " + node.data);
                if(node.left != null ) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                    continue;
                }

                if(node.left == null) {
                    node.left = new Node(data);
                    break;
                }
                if(node.right == null) {
                    node.right = new Node(data);
                    break;
                }
            }
    }

    public static boolean areTwoTreesEqualIterative(Node first, Node second) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        addIterative(first,list);
        addIterative(second,list1);
        System.out.println("List => " + list);
        System.out.println("List1 => " + list1);
        if(list.size() != list1.size()) {
            return false;
        }
        int i = 0;
        int j = 0;

        while( i < list.size() && j < list1.size()) {
            if(list.get(i) != list1.get(j)) {
                return false;
            }
            i++;
            j++;
        }


        return true;
    }

    public static void addIterative(Node node, List<Integer> list) {
        if(node == null) {
            return;
        }

        addIterative(node.left, list);
        list.add(node.data);
        addIterative(node.right,list);
    }

    public static boolean areTwoTreesEqual(Node first, Node second) {
        if(first == null && second == null) {
            return true;
        }

        return (first!= null && second != null ) && (first.data == second.data)
                && areTwoTreesEqual(first.left,second.left)
                && areTwoTreesEqual(first.right,second.right);

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
