package com.algorithms.algoExpert;

public class LinkedListLoopStart {

    public static LinkedList findLoop(LinkedList head) {
        LinkedList fast = head;
        LinkedList slow = head;
        while(slow != null && slow.next != null &&
                fast != null && fast.next != null &&
                fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                break;
            }
        }

        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
