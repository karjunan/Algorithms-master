package secondChance;

import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueTEst {

    public static void main(String[] args) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>((a,b) -> a[0].compareTo(b[0]) * -1);
        Random random = new Random();
        for(int i = 0; i < 10; i++ ) {
                Integer[] in = new Integer[2];
                in[0] = random.nextInt(10);
                in[1] = random.nextInt(20);
                pq.add(in);
        }

        print(pq);
        pq.poll();
        print(pq);
        pq.poll();
        print(pq);
        pq.poll();
        print(pq);
        pq.poll();
        print(pq);
        pq.poll();
        print(pq);
    }

    public static void print(PriorityQueue<Integer[]> pq ) {
        System.out.println("");
        pq.forEach(v -> System.out.print(v[0]+"-"+v[1]+ " ==== "));
    }
}
