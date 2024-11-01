package concepts.collection.priorityQueue;

public class PriorityQueueMain {
    public static void main(String[] args) {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>((v1,v2) -> v2-v1);
        pq.add(10);
        pq.add(2);
        pq.add(3);
        pq.add(40);
        pq.add(5);

        while (!pq.isEmpty()) {
            System.out.println(pq.pop());
        }
    }
}
