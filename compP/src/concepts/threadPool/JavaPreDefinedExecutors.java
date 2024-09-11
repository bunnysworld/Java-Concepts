package concepts.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaPreDefinedExecutors {
    public static void main(String[] args) {

        // fixed executor
//        ExecutorService fixedExecutor = Executors.newFixedThreadPool(2);
//        for (int i = 1; i <= 100; i++) {
//            int finalI = i;
//            fixedExecutor.submit(() -> {
//                System.out.println("Task " + finalI + " by thread : " + Thread.currentThread().getName());
//            });
//        }

        // cached thread pool
        ExecutorService cachedExecutor = Executors.newCachedThreadPool();
        for (int i = 1 ;i <=1000;i++){
            int f = i;
            cachedExecutor.submit(()->{
                System.out.println("Task " + f + " by thread : " + Thread.currentThread().getName());
            });
        }


    }
}
