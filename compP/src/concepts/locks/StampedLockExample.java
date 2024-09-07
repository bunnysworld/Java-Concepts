package concepts.locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
    static class Resource {
        static int a = 10;
        static StampedLock stampedLock = new StampedLock();

        private void read() {
            long stamp = stampedLock.tryOptimisticRead();
            try {
                System.out.println("Reading by Thread : " + Thread.currentThread().getName());
                a = 13;
                Thread.sleep(4000);
                if (stampedLock.validate(stamp)) {
                    System.out.println("Successfully updated the value by Thread :" + Thread.currentThread().getName());
                } else {
                    a = 10;
                    System.out.println("RollBack the value by Thread :" + Thread.currentThread().getName());
                }
            } catch (Exception e) {

            }
        }

        private void write() {
            long stamp = stampedLock.writeLock();
            try {
                System.out.println("Write by Thread : " + Thread.currentThread().getName());
                a = 20;
            } catch (Exception e) {

            }finally {
                stampedLock.unlockWrite(stamp);
            }
        }
    }

    public static void main(String[] args) {
        Resource resource1 = new Resource();
        Thread t1 = new Thread(() -> {
            resource1.read();
        });
        Resource resource3 = new Resource();
        Thread t3 = new Thread(() -> {
            resource3.read();
        });

        Resource resource2 = new Resource();
        Thread t2 = new Thread(() -> {
            resource2.write();
        });

        t1.start();
        t3.start();
        t2.start();
    }
}
