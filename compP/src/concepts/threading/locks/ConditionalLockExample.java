package concepts.threading.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionalLockExample {
    static class Resource {
        static ReentrantLock reentrantLock = new ReentrantLock();
        static Condition condition = reentrantLock.newCondition();
        static boolean isPresent = true;

        public void consume() {
            try {
                Thread.sleep(1000);
                reentrantLock.lock();
                System.out.println("Consumer lock acquired by "+Thread.currentThread().getName());
                if (!isPresent) {
                    System.out.println("consumer lock is going await Thread : " + Thread.currentThread().getName());
                    condition.await();
                }
                isPresent = false;
                condition.signal();
            } catch (Exception e) {

            } finally {
                reentrantLock.unlock();
                System.out.println("consumer lock is released");
            }
        }

        public void produce() {
            reentrantLock.lock();
            try {
                System.out.println("Produce lock acquired by thread : " + Thread.currentThread().getName());
                if (isPresent) {
                    System.out.println("Producer is waiting going await Thread : " + Thread.currentThread().getName());
                    condition.await();
                }
                isPresent = false;
                condition.signal();
            } catch (Exception e) {

            } finally {
                reentrantLock.unlock();
                System.out.println("Producer lock is released");
            }
        }
    }

    public static void main(String[] args) {
        Resource r1 = new Resource();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                r1.consume();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i<3;i++){
                r1.produce();
            }

        });

        t1.start();
        t2.start();
    }
}
