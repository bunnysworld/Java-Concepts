package concepts.threadPool;

import java.util.concurrent.*;

public class ForkJoinPoolExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool(4);
        Future<Integer> future = executorService.submit(() -> {
            return new ComputeSubTask(0,100).compute();
        });
        System.out.println(future.get());
    }
}

class ComputeSubTask extends RecursiveTask<Integer> {
    int start = 0;
    int end = 0;

    public ComputeSubTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 4) {
            System.out.println("end : "+end+" start : "+start+" Thread : "+Thread.currentThread()
                    .getName());
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            ComputeSubTask leftTask = new ComputeSubTask(start, mid - 1);
            ComputeSubTask rightTask = new ComputeSubTask(mid, end);

            leftTask.fork();
            rightTask.fork();

            int left = leftTask.join();
            int right = rightTask.join();
            return left + right;
        }
    }
}
