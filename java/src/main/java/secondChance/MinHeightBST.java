package secondChance;

import java.util.ArrayList;
import java.util.List;

public class MinHeightBST {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,5,7,10,13,14,15,22);
        Node root = constructBst(list,0, list.size()-1);
        inOrder(root);
    }

    public static void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.println(node.value + " ");
            inOrder(node.right);
        }
    }

    public static Node constructBst(List<Integer> array, int startIDX, int endIDX) {
            if(startIDX > endIDX) {
                return null;
            }

            int mid = (startIDX + endIDX) / 2;
            Node node = new Node(array.get(mid));
            node.left = constructBst(array,startIDX, mid-1);
            node.right = constructBst(array,mid+1, endIDX);
            return node;
    }

    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }
    }
}
