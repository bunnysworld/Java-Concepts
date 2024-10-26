package concepts.reflection.waysToGetReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionSingleTonMain {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class obj = ReflectionSingleTonClass.class;

        Constructor[] constructors = obj.getDeclaredConstructors();
        for (Constructor c : constructors) {
            c.setAccessible(true);
            ReflectionSingleTonClass reflectionSingleTonClass = (ReflectionSingleTonClass) c.newInstance();
            reflectionSingleTonClass.accessMe();
        }
    }

}
