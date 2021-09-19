class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}
class Queue {
    constructor(node) {
        this.node = node;
        this.head = node;
        this.tail = node;
    }

    enqueue(node) {
        if(this.tail === null) {
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = this.tail.next;
        }
    }
    dequeue(node) {
        if(this.head === null) {
            return Number.MIN_SAFE_INTEGER
        } else {
            var temp = this.head.next;
            this.head = null
            this.head = temp;
        }
    }

    iterate(node) {
        while(node != null) {
            console.log(node.data)
            node = node.next;
        }
    }

    reverseLinkedList(node) {
        var p = node;
        var q = null;
        var r = null;
        while(p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
          console.log(p)
        }
        this.head = q;
    }

    recursiveReversal(current) {
        var prev = current;
        if(current.next != null) {
            var t = this.recursiveReversal(current.next);
            t.next = prev;
            prev.next = null;
        } else {
            this.head = prev;
        }
        return prev;

    }
}

var q = new Queue(new Node(10));
q.enqueue(new Node(20));
q.enqueue(new Node(30));
q.enqueue(new Node(40));
q.enqueue(new Node(50));
q.enqueue(new Node(60));
// q.dequeue();
// q.iterate(q.head);
// console.log("Done ----")
// q.dequeue();
// q.dequeue();
// q.dequeue();
// console.log("Done ----")
q.iterate(q.head);
console.log("Done ----")
// q.reverseLinkedList(q.head);
q.recursiveReversal(q.head)
q.iterate(q.head)
