package secondChance;

import com.algorithms.algoExpert.BST;
import com.google.Bst;

public class FindClosestValueinBST {

    static BST.Node root = null;
    public static void main(String[] args) {

        root = BST.add(10, root);
        root = BST.add(5, root);
        root =  BST.add(15, root);
        root =  BST.add(2, root);
        root =  BST.add(5, root);
        root =   BST.add(13, root);
        root =  BST.add(22, root);
        root = BST.add(1, root);


        int target = 12;

        BST.inOrder(root);

        int closest = findClosest(root, target, root.value);
        System.out.println("The closest value is => " + closest);
    }

    public static int findClosest(BST.Node tree, int target, int closest) {

        if(Math.abs(tree.value - target) < Math.abs(target - closest)) {
            closest = tree.value;
        }

        if(tree.value > target && tree.left != null) {
            return findClosest(tree.left,target, closest);
        } else if(tree.value < target && tree.right != null) {
            return findClosest(tree.right, target, closest);
        } else {
            return closest;
        }
    }


}
