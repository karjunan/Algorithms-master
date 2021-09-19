package secondChance.revision;

public class BST {

    static Node root = null;
    public static void main(String[] args) {
        add(50);
        add(25);
        add(75);
        add(20);
        add(30);
        add(27);
        add(26);
        add(28);

        inOrder(root);
        delete(50, root);
        System.out.println(" ---- ");
        inOrder(root);
        System.out.println(" ---- ");
        preOrder(root);
    }

    public static void delete (int val, Node root) {

        delete(val, root, null);
    }

    public static Node delete(int val, Node node, Node prev) {
        if(node == null) {
            return node;
        }

        if(val < node.val) {
            node.left = delete(val, node.left, node);
        } else if(val > node.val) {
            node.right = delete(val, node.right, node);
        } else {
            // case 1: when the node has no children
            if(node.left == null && node.right == null) {
                node = null;
            } else if(node.left != null && node.right == null) {
                node = node.left;
            } else if(node.left == null && node.right != null) {
                node = node.right;
            } else {
                Node leftMin = getLeftMin(node.right);
                node.right = delete(leftMin.val, leftMin, leftMin);
                node.val = leftMin.val;
            }
        }
        return node;
    }

    private static Node getLeftMin(Node right) {
        Node current = right;
        while(current != null && current.left != null) {
            current = current.left;
        }

        return current;
    }

    public static void add(int val) {
        if(root == null) {
            root = new Node(val);
        } else {
            root = add(val,root);
        }

    }

    public static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    public static void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.val + " ");
        inOrder(node.left);
        inOrder(node.right);
    }


    public static Node add(int val, Node node) {
        if(node == null) {
            return new Node(val);
        } else if(val < node.val) {
            node.left = add(val, node.left);
        } else {
            node.right = add(val, node.right);
        }
        return node;
    }
    
    
    static class Node {
        Node left;
        Node right;
        int val;
        
        Node(int val) {
            this.val = val;
        }
    }
}
