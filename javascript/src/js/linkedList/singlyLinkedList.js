class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class SingleLinkedList {

    constructor() {
        this.head = null;
        this.tail = null;
    }


    add(data) {
        if(this.head == null) {
            this.head = new Node(data);
            this.tail = this.head;
        } else {
           this.tail.next = new Node(data);
           this.tail = this.tail.next;
        }
    }

    print() {
        console.log(JSON.stringify(this.head))
    }

    setHead(node) {
        var temp = this.head;
        this.head = node;
        node.next = temp;

    }

    setTail(node) {
        this.tail.next = node;
    }

    remove(node) {
        var temp = this.head;
        if(temp.data === node.data) {
            var t1 = temp.next;
            temp = null;
            this.head = t1;
            return;
        }

        while(temp != null) {
            var prev = temp;
            if(temp.next != null && temp.next.data === node.data) {
                var t1 = temp.next.next;
                temp.next = null;
                prev.next = t1;
                return;
            }
            temp = temp.next;
        }
    }

    containNodeWithValue(value) {
        var temp = this.head;
        while(temp != null) {
            if(temp.data === value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    removeNodesWithValue(value){
        var temp = this.head;
        if(temp.data === value) {
            var t1 = temp.next;
            temp = null;
            this.head = t1;
            return;
        }

        while(temp != null && temp.next != null) {
            var prev = temp;
            temp = temp.next;
            if(temp.data === value) {
                var t1 = temp.next;
                temp = null;
                prev.next = t1;
                temp = prev;
            }
            
        }
    }

    insertBefore(node,nodeToInsert) {
        this.remove(new Node(nodeToInsert));
        var temp = this.head
        console.log(`Removing ${nodeToInsert} => `, JSON.stringify(temp))
        if(node == temp.data) {
            this.setHead(new Node(nodeToInsert));
        } else {
           while(temp != null && temp.next != null) {
                var prev = temp;
                if(temp.next.data == node) {
                    var t1 = temp.next;
                    temp.next = null;
                    prev.next = new Node(nodeToInsert);
                    prev.next.next = t1;
                    return;
                }
                temp = temp.next;
           }
        }
    }

    insertAfter(node, nodeToInsert) {
        var temp = this.head;
        while(temp != null) {
            if(temp.data === node) {
                var t1 = temp.next;
                temp.next = null;
                temp.next = new Node(nodeToInsert);
                temp.next.next = t1;   
            }
            temp = temp.next;
        }
    }

    insertAtPosition(position, nodeToInsert) {
        if(position == 1) {
            this.setHead(new Node(nodeToInsert));
        } else {
            var temp = this.head;
            var counter = 1;
            while(temp != null) {
                if(position == counter) {
                    console.log("Reached position => " + temp.data);
                    var t1 = temp;
                    prev.next = null;
                    prev.next = new Node(nodeToInsert);
                    prev.next.next = t1;
                }
                counter++;
                var prev = temp;
                temp = temp.next;
            }
        } 

    }

    iterate() {
        var temp = this.head;
        while(temp != null) {
            console.log(temp.data);
            temp = temp.next;
        }
    }

    removeKthNodeFromEnd(head, k) {
           
    }

    reverseLinkedList() {
        this.reverseLinkedListHelper(this.head)
    }

    reverseLinkedListHelper(head) {
        if(head === null || head.next === null ) {
            this.head = head;
            return head;
        }
        var temp = head.next;
        this.reverseLinkedListHelper(head.next);
        head.next = null;
        temp.next = head;
    }


}

let list = new SingleLinkedList();
list.add(20);
list.add(900)
list.add(50);
list.add(60);
list.add(23);
list.add(45);
list.print()
list.reverseLinkedList();
list.print()
// list.add(10);
// list.add(20);
// list.add(30);
// list.print();
// list.iterate()
// list.setHead(new Node(15))
// list.print()
// list.setTail(new Node(100));
// list.print()
// list.remove(new Node(10))
// list.print();
// list.remove(new Node(100))
// list.print();
// let val = 20
// var result = list.containNodeWithValue(val);
// console.log(`Element ${val}  present = `, result)
// val = 39
// result = list.containNodeWithValue(val);
// console.log(`Element ${val}  present = `, result)


// list.removeNodesWithValue()
// list.removeNodesWithValue(20);
// list.print()
// list.insertAtPosition(1,400)
// list.print()
// list.insertAtPosition(2,600)
// list.print()
// list.insertAtPosition(3,600)
// list.print()
// list.insertAtPosition(8,000)
// list.print()
// list.insertAfter(60,500)
// list.print()
// list.insertBefore(400,600)
// list.print()

// list.insertBefore(15,30)
list.print()