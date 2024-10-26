package concepts.collection.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class QueueMain {
    public static void main(String[] args) {
        CustomQueueClass<Integer> queue = new CustomQueueClass<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.poll();
        }

        List<String> words = Arrays.asList("abc","bcde","er");
        Stream<String> stream = words.stream();
        stream = stream.filter(f -> f.length() > 2);
        long count = stream.count();
        System.out.println(count);

    }
}
