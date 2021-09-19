package secondChance;

import java.util.PriorityQueue;

public class Pq {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        pq.add(-1);
        pq.add(-3);
        pq.add(-4);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
