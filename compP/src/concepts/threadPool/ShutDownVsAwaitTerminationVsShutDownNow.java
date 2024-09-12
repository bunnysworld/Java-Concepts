package concepts.threadPool;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.*;

public class ShutDownVsAwaitTerminationVsShutDownNow {
    public static void main(String[] args) throws InterruptedException {
        // shutdown
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        for (int i = 1; i<=4;i++){
//            executorService.submit(() ->{
//                System.out.println("Task ");
//            });
//        }
//        executorService.shutdown();
//        executorService.submit(()-> System.out.println("task 2"));


        // AwaitTermination
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 4, 0,
//                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),
//                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
//
//        executor.submit(() -> {
//            try {
//                Thread.sleep(3000);
//                System.out.println("Task finished");
//            } catch (Exception e) {
//
//            }
//        });
//        System.out.println("main thread");
//        try {
//            executor.shutdown();
//            System.out.println(executor.awaitTermination(1, TimeUnit.SECONDS));
//        } catch (Exception e) {
//            System.out.println("Exception "+ e);
//        }

        // shutdownnow

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 1;i<10;i++){
            executorService.submit(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread ");
            });
        }
        System.out.println("main thread");
        Thread.sleep(2000);
        List<Runnable> li = executorService.shutdownNow();

    }
}
