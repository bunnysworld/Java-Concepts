package concepts.threading.atomicVariables;

public class ExampleWithoutAtomic {
    static class Resource{
        int a = 0;

        public int getA() {
            return a;
        }

        public void setA() {
//            System.out.println("update by Thread : "+Thread.currentThread().getName());
            this.a++;
        }
    }

    public static void main(String[] args) {
        Resource resource = new Resource();

        Thread t1 = new Thread(()->{
            for (int i = 0;i<5000;i++){
                resource.setA();
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0;i<400;i++){
                resource.setA();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (Exception e){

        }
        System.out.println(resource.getA());
    }
}
