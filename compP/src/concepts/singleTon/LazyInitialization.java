package concepts.singleTon;

public class LazyInitialization {

    private static LazyInitialization obj = null;

    private LazyInitialization() {

    }

    public static LazyInitialization getInstance() {
        if (obj == null) {
            obj = new LazyInitialization();
        }
        return obj;
    }
}
