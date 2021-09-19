package com.java8;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {

        PriorityQueue<Item> pq = new PriorityQueue<Item>(5,(a,b) -> a.val.compareTo(b.val));

        Item item1 = new Item(9,2);
        Item item2 = new Item(3,2);
        Item item3 = new Item(9,2);
        Item item4 = new Item(1,2);
        pq.add(item1);
        pq.add(item2);
        pq.add(item3);
        pq.add(item4);
        System.out.println(pq.poll().val);
    }

    static class Item {
        Integer val;
        Integer val1;
        Item(Integer val, Integer val1) {
            this.val = val;
            this.val1 = val1;
        }
    }
}
