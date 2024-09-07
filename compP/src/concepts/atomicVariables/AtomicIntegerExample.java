package concepts.atomicVariables;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    static class Resource{
        AtomicInteger atomicInteger = new AtomicInteger(0);

        public int getAtomicInteger() {
            return atomicInteger.get();
        }

        public void setAtomicInteger() {
            this.atomicInteger.getAndIncrement();
        }
    }

    public static void main(String[] args) {
        Resource resource = new Resource();

        Thread t1 = new Thread(()->{
            for (int i = 0;i<5000;i++){
                resource.setAtomicInteger();
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0;i<400;i++){
                resource.setAtomicInteger();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (Exception e){

        }
        System.out.println(resource.getAtomicInteger());
    }
}
