package concepts.reflection.waysToGetReflection;

public class ReflectionMain {
    public static void main(String[] args) throws ClassNotFoundException {
        Class obj = Class.forName("ReflectionClass");

        Class obj2 = ReflectionClass.class;

        ReflectionClass reflectionClass = new ReflectionClass();
        Class obj3 = reflectionClass.getClass();


    }
}
