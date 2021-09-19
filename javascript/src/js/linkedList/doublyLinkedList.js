class Node {
    constructor(value) {
      this.value = value;
      this.prev = null;
      this.next = null;
    }
}
class DoublyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    setHead(node) {
        if(this.head === null) {
            this.head = node;
            this.tail = node;
            this.length++;
            return;
        }
        // this is the first node
        if(this.length == 1 && node.value === this.head.value) {
            return;
        }
        
        if(this.length >= 1) {
            var val = this.find(node);
            if(val != null) {
                this.remove(val)
            }
            this.shead(node)
        }
        
        this.length++;
        return this.head;
    }

    shead(node) {
        var temp = this.head;
        node.next = temp;
        temp.prev = node;
        this.head = node;
    }

    setTail(node) {
        if(this.tail === null) {
            this.head = node;
            this.tail = node;
            this.length++;
            return;
        }

        // this is the first node
        if(this.length == 1 && node.value === this.tail.value) {
            return;
        }

        if(this.length >= 1) {
            var t = this.find(node);
            if(t != null) {
                this.remove(t);
            }
            this.sTail(node);
        }
        this.length++;

    }

    sTail(node) {
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = this.tail.next;
    }
    shift() {
        if(this.head === null) {
            return;
        }
        if(this.length === 1) {
            this.head = null;
            this.tail = null;
            this.length--;
            return;
        } 
        if(this.length > 1) {
            this.head = this.head.next;
            this.head.prev = null;
            this.length--;
        } 
    }

    unShift() {
        if(this.tail === null) {
            return undefined;
        }
        if(this.length === 1) {
            this.head = null;
            this.tail = null;
        } 
        if(this.length > 1) {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
      
        this.length--;
        return this.head;
    }

   
// 10 20 30

    find(node) {
        var temp = this.head;
        while(temp != null) {
            if(temp.value === node.value) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    get(index) {
        var temp = this.head;
        var current = 0;
        var node = null;
        while(temp != null) {
            if(current === index) {
                node = temp;
                break;
            }
            current++;
            temp = temp.next;
        }
        return node;
    }

    print() {
        console.log(this.head)
        // console.log(this.tail)
        // console.log(JSON.stringify(this.head));
    }
    
    printReverse() {
        console.log(this.tail)
        // console.log(this.tail)
        // console.log(JSON.stringify(this.head));
    }
    iterate() {
        var temp = this.head;
        while(temp != null) {
            console.log(temp.value)
            temp = temp.next;
        }
    }
    printLength() {
        console.log("Current Length is => ", this.length)
        // console.log(this.tail)
        // console.log(JSON.stringify(this.head));
    }

    remove(node) {
        
        if(this.length === 0 || node === null) {
            return 
        }
       
        if(this.length === 1) {
            this.head = null
            this.tail = null
            this.length--;
            return;
        }
       
        var temp = this.head;
        var prev = this.head;
        if(this.length > 1 && temp.value === node.value) {
            this.shift(node); 
            this.length--;
            return;
        }        
        console.log("Removing data !!")
        var temp = this.find(node);
        if(temp.next == null) {
            this.unShift(node);
            this.length--;
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        this.length--;
        // 10 20 30 40
    }

    
    containsNodeWithValue(value) {
        var node = this.find(new Node(value));
        if(node != null ){
            return true;
        }
        return false;
    }


    removeNodesWithValue(value) {
       var temp = this.head;
       while(temp != null) {
           if(temp.value == value) {
               this.remove(temp);
           }
           temp = temp.next;
       }
    }

    insertAfter(node, nodeToInsert) {
        var n = this.find(node);
        if(n == null) {
            return null;
        }

        if(n.next === null) {
            this.setTail(nodeToInsert);
            return;
        }
        
        if(n.prev === null) {
            this.setHead(nodeToInsert);
            return;
        }
        
        var temp = n.next;
        n.next.prev = null;
        n.next = null;
        n.next = nodeToInsert
        nodeToInsert.prev = n
        nodeToInsert.next=temp;
        temp.prev = nodeToInsert;
    }

}


let list = new DoublyLinkedList();
// console.log(list);
list.setHead(new Node(5));
list.setHead(new Node(2));
list.setHead(new Node(1));
list.setHead(new Node(1));

// list.print()

// list.setTail(new Node(7))
// list.iterate()
list.printLength()
list.iterate()
list.removeNodesWithValue(1);
list.printLength()
list.iterate()
list.printLength()

// list.setTail(new Node(20));
// list.setTail(new Node(30));
// 0  10 20 30
// list.remove(new Node(0))
// list.remove(new Node(30))
// list.print()
// console.log(list.containsNodeWithValue(0));

// list.removeNodesWithValue(30)
// list.insertAfter(new Node(30),new Node(45))
// list.print()
// console.log(list.containsNodeWithValue(45));
// list.printLength()
// list.insertAfter(new Node(45),new Node(80))
// list.printLength()
// list.printReverse()