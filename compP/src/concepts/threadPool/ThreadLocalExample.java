package concepts.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        executorService.scheduleAtFixedRate(()->{
             int count = threadLocal.get();
             count++;
             threadLocal.set(count);
            System.out.println("Thread "+Thread.currentThread().getName()+" count "+count);
        },1,1, TimeUnit.SECONDS);
    }
}
