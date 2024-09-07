package concepts.threadPool;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.submit(() -> {
                try {
                    System.out.println("Task executed by thread " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (Exception e) {

                }
            });
        }

    }
}

class CustomRejectionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task rejected : " + r.toString());
        ;
    }
}
