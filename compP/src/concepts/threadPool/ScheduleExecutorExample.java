package concepts.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorExample {
    public static void main(String[] args) {
        // schedule
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
//        scheduledExecutorService.schedule(() -> System.out.println("Task"),2, TimeUnit.SECONDS);
//        System.out.println("Main thread");

        //schedule at fix rate
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//        scheduledExecutorService.scheduleAtFixedRate(() ->
//                System.out.println("task"), 2, 2, TimeUnit.SECONDS);
//        System.out.println("main thread");
//        try {
//            Thread.sleep(10000);
//            System.out.println("cancelling");
//            scheduledExecutorService.shutdown();
//            System.out.println("cancelled");
//        }catch (Exception e){
//
//        }

        //scheduled at fixed delay
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleWithFixedDelay(() -> {
            System.out.println("Task");
        }, 2, 2, TimeUnit.SECONDS);

    }
}
