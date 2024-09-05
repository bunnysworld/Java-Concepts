package concepts.threading.locks;

import java.util.concurrent.Semaphore;

public class SemaphoreLockExample {
    static class Resource{
        static Semaphore semaphore = new Semaphore(3    );
        public void read(){
            try {
                semaphore.acquire();
                System.out.println("Lock acquire by Thread : "+Thread.currentThread().getName());
                Thread.sleep(3000);
            }catch (Exception e){

            }finally {
                System.out.println("Release by Thread : "+Thread.currentThread().getName());
                semaphore.release();
            }

        }
    }

    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread t1 = new Thread(() -> {
            resource.read();
        });

        Resource resource2 = new Resource();
        Thread t2 = new Thread(() -> {
            resource2.read();
        });

        Resource resource3 = new Resource();
        Thread t3 = new Thread(() -> {
            resource3.read();
        });

        Resource resource4 = new Resource();
        Thread t4 = new Thread(() -> {
            resource4.read();
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
