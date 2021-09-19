class Node {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    constructor() {
        this.root = null;
    }

    insert(value) {
        var node = new Node(value);
        var queue = []
        if(this.root === null) {
             this.root = node;
             return
        } else if(this.root.left === null) {
            this.root.left = node
            return;
        } else if(this.root.right === null) {
            this.root.right = node;
            return;
        }
        queue.push(this.root);
        queue.push(this.root.left);
        queue.push(this.root.right);

        console.log("queue values", queue.length)
        while(queue.length > 0) {
            var n = queue.shift();
            console.log("Nth value => " + JSON.stringify(n))
            if(n.left === null) {
                n.left = node;
                break;
            } else if(n.right === null) {
                n.right = node;
                break;
            }
        }
        return this.root;
    }

    inOrderTraversal(root) {
        if(root != null) {
            this.inOrderTraversal(root.left);
            console.log(root.value)
            this.inOrderTraversal(root.right);
        }
    }
   
    bfs(root) {
        var queue = []
        queue[0] = root;
        while(queue.length > 0 ) {
            var n = queue.shift();
            console.log(n.value);
            if(n.left != null) {
                queue.push(n.left);
            } 
            if(n.right != null) {
                queue.push(n.right);
            }
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

    //current min        max
    //10,     infinity, infinity
    // 5,     infinity  10
    // 2      infinity  5  
    // 1      infinity  2
    // 
    } 

}

let bt = new BinaryTree();
bt.insert(10)
bt.insert(5)
bt.insert(15)
var root = bt.insert(2)
bt.insert(5)
bt.insert(13)
bt.insert(22)
bt.insert(14)


// console.log(bt);
bt.bfs(root)
console.log("=====================")
bt.inOrderTraversal(root)
let isTrue = bt.isBST(root,Number.MIN_SAFE_INTEGER,Number.MAX_SAFE_INTEGER)
console.log("IS Bst => ", isTrue)