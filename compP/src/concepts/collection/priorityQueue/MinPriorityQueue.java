package concepts.collection.priorityQueue;

import java.util.PriorityQueue;

public class MinPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(1);
        queue.add(7);
        queue.add(0);
        queue.forEach((i) -> {
            System.out.print(": " + i);
        });
        System.out.println();
        while (!queue.isEmpty()) {
            System.out.print(":" + queue.poll());
        }

    }
}
