package concepts.singleTon;

public class EagerInitialization {

    private static EagerInitialization obj = new EagerInitialization();

    private EagerInitialization() {
    }

    public static EagerInitialization getInstance(){
        return obj;
    }

}
