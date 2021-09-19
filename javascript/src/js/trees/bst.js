
class BST {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

  
    contains(value) {
        if (value < this.value && this.left != null) {
            return this.left.contains(value);
        } else if (value > this.value && this.right != null) {
            return this.right.contains(value);
        } else if (value === this.value) {
            return true;
        }
        return false;
    }

    remove(value,root) {
        console.log("Entering Remove ")
        if(root === null) {
            return null;
        }
        if(value < root.value) {
            root.left = root.remove(value,root.left);
            return root;
        } else if(value > root.value) {
            root.right = root.remove(value,root.right);
            console.log("Doing stuff", root.value)
            return root;
        } else {
            console.log("Found the value to be removed")
            //case 1: when a node dosent have any childs
            if(root.left === null && root.right === null) {
                console.log("Both the sides are null and remove the node");
                root = null;
                return root;
            } else if(root.left === null && root.right != null) {
                root = root.right;
                return root;
            } else if(root.left != null && root.right === null) {
                root = root.left;
                return root;
            } else if(root.left != null && root.right != null) {
                console.log("Gettin into not null condition on both sides");
                var element = this.findMin(root.right);
                root.value = element.value;
                root.right = root.remove(element.value,root.right);
                return root;

            }

        }

    }

    findMin(node) {
        if(node != null && node.left != null) {
            return node.findMin(node.left)
        }
        return node;
    }


    inOrder() {
        this.inOrderTraversal(this);
    }

    inOrderTraversal(root) {
        if (root != null) {
            console.log(root.value);
            this.inOrderTraversal(root.left);
            this.inOrderTraversal(root.right);
            
        }
    }

    insert(value) {
        var root = this;
        this.insertHelper(value,root)
    }

    insertHelper(value,root) {
       if(root === null) {
           root = new BST(value);
           console.log("Root value being set ", root.value)
           return root;
       }
       if(value < root.value) {
           console.log("value is less ", root.value,value)
           root.left = root.insertHelper(value,root.left);
           return root;
       } else  {
            console.log("value is more ", root.value, value)
           root.right = root.insertHelper(value,root.right);
           return root;
       } 
    }

    isBST(root, min, max) {
        if(root === null) {
            return true;
        }
        if(root.value < min || root.value > max) {
            return false;
        }
        console.log("Min and root value " + min,max)
        var isValidLeft = this.isBST(root.left,min,root.value);
        console.log("Min and root value after left traversal => " + min,max)
       
        var isValidRight = this.isBST(root.right,root.value,max);
        return isValidLeft && isValidRight; 
    } 

    findClosest(root,target,closest) {
        if(root == null) {
            return closest;
        }

        if(Math.abs(closest - target) > Math.abs(root.value - target)) {
            closest = root.value;
        }
        if(target > root.value) {
             closest = this.findClosest(root.right,target, closest);
        } else {
             closest = this.findClosest(root.left,target,closest);
        }
        return closest
    }

    minHeightBst(array) {
    
        this.minHeightBstHelper(array,0,array.length)

    }

    minHeightBstHelper(array,left,right) {
        if(right < left) {
            return ;
        }
        var mid = Math.floor((left+right)/2);
        this.insert(array[mid]);
        this.minHeightBstHelper(array,left, mid-1);
        this.minHeightBstHelper(array,mid+1,right);
    }
    

}
var bst = new BST(0);
// bst.inOrder();
// bst.insert(15);
// bst.insert(2);
// bst.insert(5);
// bst.insert(13);
// bst.insert(22);
// bst.insert(1);
// bst.insert(14);
// bst.insert(12);
// bst.insert(10);
// bst.insert(54);

// bst.inOrderTraversal(bst)
// bst.remove(10,bst)

// bst.inOrderTraversal(bst)
// let result = bst.isBST(bst,Number.MIN_SAFE_INTEGER,Number.MAX_SAFE_INTEGER);
// console.log("IS Bst => ", result);

// let closest = bst.findClosest(bst,20,Number.MAX_SAFE_INTEGER)
// console.log("The closest number => ", closest)

let array = [1,2,4,5,6,7,8,10,34,65,75]
bst.minHeightBst(array);
bst.inOrder()
// console.log("next inserts");
// // bst.inOrder();
// let msg = bst.contains(10);
// console.log("Is the record avaliable => ", msg);
// let min = bst.findMin(bst);
// console.log("Min is => ", min.value)
// bst.remove(40,bst);
// bst.remove(30,bst);
// bst.inOrder();
// console.log(bst.contains(9));

/*

     3
   2   5
              10
          
          5
        2        15
      1        5      22   
                 13
               12  14
remove 10
*/