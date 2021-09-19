package com.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class BinarySearchTree {

    public static Node root;

    public static void main(String[] args) {

       addR(50);
       addR(48);
       addR(55);
       addR(53);
       addR(47);
       addR(56);
       addR(57);
       addR(1);
       addR(23);
       addR(21);
       addR(76);
       addR(45);
      // print();
//       delete(48);
       print();

       //inOrder(root);
        //preOrderTraversal(root);
        preOrderIt(root);
        inOrderIt(root);
        postOrderit(root);
//        System.out.println("-----PreOrder---------");
//        preOrderTraversal(root);
//        System.out.println("-----InOrder---------");
//        inOrderTraversal(root," ");
//        System.out.println("-----PostOrder---------");
//        postOrderTraversal(root);
//        System.out.println("-----BFS---------");
//        bfs();

//        System.out.println("-----InOrder---------");
//        inOrderTraversal(root," ");
//        delete(11,root,root);
//        delete(123,root,root);
//        delete(31,root,root);
//        System.out.println("-----InOrder After deletion ---------");
//        inOrderTraversal(root,"");
//<<<<<<< HEAD
//       Node val = findCommonAncestor(5,26,root);
//=======
//        Node val = findCommonAncestor(5,26,root);
//>>>>>>> 132faae1bfbebe43b0c6e70327d9ed9f0f9453a0
//        System.out.println("LCA : ["+val.data+"]");
//        System.out.println(height(root));
//        System.out.println("Root to leaf sum :: " + rootToleafSum(root));
//        System.out.println("Size of the Tree is :;" + sizeOfTree(root));
//<<<<<<< HEAD
//        System.out.println(checkIfBST(root, Integer.MAX_VALUE,Integer.MIN_VALUE));
//        Stack<Integer> stack = new Stack<>();
//        inOrderPredessor(root,stack,50);
//        preOrderIterative(root);
//        inOrderIterative(root);
//        inorderWithoutRecurssion(root);
    }

    public static void preOrderIt(Node node) {
        System.out.println(" \n ");
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while(temp != null || !stack.isEmpty()) {
            if(temp != null) {
                System.out.print(temp.data + " ");
                stack.push(temp);
                temp = temp.left;
            } else {
                Node t = stack.pop();
                temp = t.right;
            }
        }
    }

    public static void inOrderIt(Node node) {
        System.out.println("\n");
        Node temp = node;
        Stack<Node> stack = new Stack<>();
        while(temp != null || !stack.isEmpty()) {
            if(temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                Node t = stack.pop();
                System.out.print(t.data + " ");
                temp = t.right;
            }
        }
    }

    public static void postOrderit(Node node) {
        System.out.println("\n");
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack1 = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
           // System.out.println("Post order work ");
            Node current = stack.pop();
            stack1.push(current);
            while(current.left != null) {
                stack.push(current.left);
            }
            while(current.right != null) {
                stack.push(current.right);
            }
            while(!stack1.isEmpty()) {
                System.out.print(stack1.pop().data + " ");
            }
        }
    }
    public static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }


    public static int close(int val, Node node, int closest,int rs) {
        if(node != null ) {
            int val1 = 0;
            int result = Math.abs(val - node.data);
            if(result < closest) {
                closest = result;
                rs = node.data;
                System.out.println("\nVal -> " + rs + " = " + result);
            } else if(result == 0) {
                System.out.println("Not continuint");
                return node.data;
            }
            if(val < node.data) {
                rs = close(val,node.left,closest,rs);
            } else{
                rs = close(val,node.right,closest,rs);
            }
        }
        return rs;
    }

    public static Node kthSmallest(Node node, AtomicInteger integer, int k) {

        if(node == null) {
            return new Node(Integer.MAX_VALUE);
        }

        Node result = kthSmallest(node.left,integer,k);

        int val = integer.getAndIncrement();

        if(result.data != Integer.MAX_VALUE) {
            System.out.println("kth lower values >>> " + node.data + ":"+ result.data);
            return result;
        }

        if(k == val) {
            System.out.println("kth equal >>> " + node.data + ">>" + result.data);
            return node;
        }

        System.out.println("Coming to the end of the loop");
        return kthSmallest(node.right,integer,k);


    }


    public static void inOrderPredessor(Node node, Stack<Integer> list, int data) {

        if(node == null ) {
            return;
        }
        inOrderPredessor(node.left,list,data);
        if(!list.isEmpty() && list.peek() == data) {
            list.pop();
            if(list.isEmpty()) {
                System.out.println("No Predessors ");
                return;
            }
            System.out.println(" Predessor is : " + list.peek());
            return;
        }
        list.add(node.data);
        inOrderPredessor(node.right,list,data);
    }


    public static boolean checkIfBST( Node node, int min , int max ) {
        if(node == null) {
            return true;
        } else {

            if(node.data < min ||  node.data > max) {
                checkIfBST(node.left,node.data,node.data);
            } else {
                return false;
            }

            if(node.data < min ||  node.data > max) {
                checkIfBST(node.right,node.data,node.data);
            } else {
                return false;
            }


        }

        return true;

//=======
//        allPath(root,new ArrayList<>(),new ArrayList<>());
//>>>>>>> 132faae1bfbebe43b0c6e70327d9ed9f0f9453a0
    }


    public static void allPath(Node node,List<Integer> list,List<List> finalList) {
        if(node == null) {
            return ;
        }
        list.add(node.data);
//        finalList.add(list);
        allPath(node.left,list,finalList);
        finalList.add(list);
        System.out.println(finalList);
        list.remove(list.size()-1);
        allPath(node.right,list,finalList);
        finalList.add(list);
    }

    public static int height(Node node) {
        if(node == null) {
            return 0;
        }
        return Math.max(height(node.left)+1,height(node.right)+1);
    }


    public static int sizeOfTree(Node node) {
        if(node == null) {
            return 0;
        }

        return 1+ sizeOfTree(node.left)+sizeOfTree(node.right);
    }

    public static int rootToleafSum(Node node) {
        if(node == null) {
            return 0;
        }
         return rootToleafSum(node.left) + rootToleafSum(node.right) + node.data;
    }

    public static Node findCommonAncestor(int n1, int n2, Node node) {
        if (node != null) {
            if (n1 < node.data && n2 < node.data) {
                 return findCommonAncestor(n1, n2, node.left);
            } else if (n1 > node.data && n2 > node.data) {
                 return findCommonAncestor(n1, n2, node.right);
            } else {
//                return node;
            }
        }
        return node;
    }

    public static void bfs() {

        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.data);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }

    }

    public static void add(int data) {
        Node node = new Node(data);
        Node temp = root;
        if(root == null) {
            root = node;
        }
        else {
            while( temp != null ) {
                if( data < temp.data )  {
                    if( temp.left != null) {
                        temp = temp.left;
                    } else {
                        temp.left = node;
                        break;
                    }
                } else if(data > temp.data) {
                    if(temp.right != null) {
                        temp = temp.right;
                    } else  {
                        temp.right = node;
                        break;
                    }
                }
            }
        }

        temp = node;
    }


    public static void addR(int data) {
        root = addRec(data,root);
    }


    public static Node addRec(int data,Node node) {
        if (node == null) {
            node = new Node(data);
            return node;
        } else if (data < node.data) {
             node.left = addRec(data, node.left);
        } else if (data > node.data) {
             node.right = addRec(data, node.right);
        }
       return node;
    }

    public static void delete(int data) {
        root = deleteRec(data,root,root);
    }
    public static Node deleteRec( int data,Node node,Node prev) {
//         System.out.println(data + ">>  " + node.data +">>  "+ prev.data );
        if(node == null) {
            return node;
        } else if(data < node.data) {
            prev = node;
            node.left = deleteRec(data,node.left,prev);
        } else if(data > node.data) {
            prev = node;
            node.right = deleteRec(data,node.right,prev);
        } else if(data == node.data){
//            System.out.println("Node to be deleted : " + node.data);
             if(node.left == null && node.right == null) {
               node = null;
               return node;
             } else if( node.left != null && node.right == null) {
                 prev.left = node.right;
                 return node.left;
             } else if( node.right != null && node.left == null) {
                 prev.right = node.left;
                 return node.right;
             } else if(node.left != null && node.right != null) {
                 System.out.println("Min element :" + getMin(node.right).data);
                 int temp = getMin(node.right).data;
                 print();
                 Node left = deleteRec(getMin(node.right).data,node.right,node);
                 node.data = temp;
                 if(left == null) {
                     node.right = null;
                 }
                 return node;
             }


        }
        return node;
    }


    public static void preOrderTraversal(Node node) {
        if(node == null)
            return;
        else {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static Node getMin(Node node) {

        if(node.left != null ) {
            Node n =  getMin(node.left);
            return n;
        }
        return node;

    }

    public static Node getMax(Node node) {

        if(node.right != null ) {
            Node n =  getMax(node.right);
            return n;
        }

        return node;

    }

    public static void print() {
        System.out.println("-----Printing start");
        inOrderTraversal(root,"");
        System.out.println("-----Printing End");
    }

    public static void inOrderTraversal(Node node,String value) {
        if(node == null)
            return;
        else {
            inOrderTraversal(node.left,"   "+value);
            System.out.println(value+ node.data+ value);
            inOrderTraversal(node.right,value+"   ");
        }
    }


    public static void inOrder(Node node,String value) throws Exception {

        if(node != null ) {
            inOrder(node.left," "+ value);
            Thread.sleep(500);
            System.out.println(value+ node.data + value);
            inOrder(node.right,value+" ");
        }
    }

    public static void postOrderTraversal(Node node) {
        if(node == null)
            return;
        else {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.data);
        }
    }

    public static class Node {

        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }

    }


    public static void invertTree(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {

            Node n = queue.poll();

            if(n != null && n.left != null && n.right != null) {
                Node temp = n.left;
                n.left = n.right;
                n.right = temp;

                queue.add(n.left);
                queue.add(n.right);


            } else if(n != null && n.right != null && n.left == null) {
                n.left = n.right;
                n.right = null;
                queue.add(n.right);


            } else if(n != null && n.left != null && n.right == null) {
                n.right = n.left;
                n.left = null;
                queue.add(n.left);
            }

        }


    }

    public static void preOrderIterative(Node root) {

        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while( !stack.isEmpty() ) {
            Node con = stack.pop();
            list.add(con.data);
            if(con.right != null) {
                stack.push(con.right);
            }
            if(con.left != null){
                stack.push(con.left);
            }
        }

        System.out.println(list);
    }

    public static void inOrderIterative(Node root) {

        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
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

        System.out.println(list);

    }

    public static void postOrderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack1 = new Stack<>();
        java.util.LinkedList<Integer> list = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node out = stack.pop();
            stack1.push(out);
            if(out.left != null) {
                stack.push(out.left);
            }

            if(out.right != null) {
                stack.push(out.right);
            }

            // stack1.forEach(v -> System.out.print("["+v.data+"]"));
            // System.out.println("");
            while(!stack1.isEmpty()) {
                list.addFirst(stack1.pop().data);
                // System.out.print("Res  >>> " + stack1.pop().data);
            }

            System.out.println("  ");
        }

        System.out.println("result >> " +list);


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
        }

        System.out.println(list);

    }

}