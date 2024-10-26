package concepts.reflection.waysToGetReflection;

public class ReflectionSingleTonClass {

    private ReflectionSingleTonClass() {

    }

    public void accessMe() {
        System.out.println("Congrats you have broken the singleton pattern !");
    }
}
