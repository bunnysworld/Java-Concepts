package concepts.threading.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    static class Resource {
        static ReentrantLock reentrantLock = new ReentrantLock();
        private void consume() {
            reentrantLock.lock();
            try {
                System.out.println("Lock acquired by thread : " + Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (Exception e) {

            } finally {
                System.out.println("lock released by Thread : " + Thread.currentThread().getName());
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Resource resource1 = new Resource();
        Thread t1 = new Thread(() -> {
            resource1.consume();
        });

        Resource resource2 = new Resource();
        Thread t2 = new Thread(() -> {
            resource2.consume();
        });

        t1.start();
        t2.start();
        System.out.println("Main thread exit");
    }
}
