package concepts.threading.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    static class Resource {
        static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        public void read() {
            try {
                readWriteLock.readLock().lock();
                System.out.println("Putting read lock by Thread : " + Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (Exception e) {

            } finally {
                System.out.println("Read Lock is removing by Thread : " + Thread.currentThread().getName());
                readWriteLock.readLock().unlock();
            }
        }

        public void write() {
            try {
                readWriteLock.writeLock().lock();
                System.out.println("Putting write lock by Thread : " + Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (Exception e) {

            } finally {
                System.out.println("Removing write lock by Thread : " + Thread.currentThread().getName());
                readWriteLock.writeLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        Resource resource1 = new Resource();
        Thread t1 = new Thread(()->{
            resource1.read();
        });

        Resource resource2 = new Resource();
        Thread t2 = new Thread(()->{
            resource2.read();
        });

        Resource resource3 = new Resource();
        Thread t3 = new Thread(()->{
            resource3.write();
        });

        t1.start();
        t2.start();
        t3.start();
        System.out.println("Main thread finished");
    }
}
