package concepts.threadPool;

public class VirtualThreadVsPlatformThreadExample {
    public static void main(String[] args) throws InterruptedException {

        // platform thread
//        Thread t1 = new Thread(() -> {
//            System.out.println("Thread 1 : "+Thread.currentThread().getThreadGroup().getName());
//            try {
//                Thread.sleep(2000);
//            }catch (Exception e){
//
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            System.out.println("Thread 2 : "+Thread.currentThread().getThreadGroup().getName());
//            try {
//                Thread.sleep(2000);
//            }catch (Exception e){
//
//            }
//        });
//        t1.start();
//        t2.start();

        // virtual thread
        Thread virtualThread = Thread.ofVirtual().start(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Virtual Thread: Iteration " + i+" Thread "+Thread.currentThread().threadId());
                try {
                    Thread.sleep(5000); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Wait for the virtual thread to complete
        try {
            virtualThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread exiting.");
    }
}
