package concepts.futureCallable;

import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 3,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(4), new ThreadPoolExecutor.DiscardPolicy());

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + " hello");
            return 1;
        }, executor);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + " hello");
            return "1";
        }, executor);

        CompletableFuture<String> combine = future1.thenCombine(future2, (Integer v1, String v2) -> v1 + v2);

        System.out.println("Main method");
        System.out.println(combine.get());

    }
}
