package concepts.futureCallable;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 2,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(1), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        Future<?> future = executor.submit(() -> {
            try {
                Thread.sleep(7000);
                System.out.println("Task is executed by thread : " + Thread.currentThread().getName());
            } catch (Exception e) {

            }
        });
        try {
            future.get(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Exception Task is not completed yet");
        }
        System.out.println("Is task done " + future.isDone());
        System.out.println("Is Task Cancelled " + future.isCancelled());
        try {
            System.out.println("Waiting for task to finish");
            future.get();
            System.out.println("task is finished ..");
        } catch (Exception e) {

        }
        System.out.println("After waiting is Task Done "+future.isDone());
    }
}
