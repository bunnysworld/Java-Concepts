package concepts.singleTon;

public class SynchronizedSingleTon {
    private static SynchronizedSingleTon obj;

    private SynchronizedSingleTon() {

    }

    public synchronized static SynchronizedSingleTon getInstance() {
        if (obj == null) {
            obj = new SynchronizedSingleTon();
        }
        return obj;
    }
}
