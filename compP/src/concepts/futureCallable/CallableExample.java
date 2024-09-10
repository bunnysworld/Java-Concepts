package concepts.futureCallable;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 2,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(1), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        int a = 3;
        Future<Integer> future = executor.submit(() -> {
            System.out.println("Task-1 of return type Integer");
            return 12 + a;
        });
        try {
            System.out.println("Returned value from Task-1 : " + future.get());
        } catch (Exception e) {

        }
        String s = "abc";
        Future<String> future1 = executor.submit(() -> {
            System.out.println("Task-2 of return type string");
        }, s.toUpperCase());

        try {
            System.out.println("Returned value by Task-2 : " + future1.get());
        } catch (Exception e) {

        }

    }
}
