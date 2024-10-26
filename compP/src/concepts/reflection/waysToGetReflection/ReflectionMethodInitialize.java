package concepts.reflection.waysToGetReflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMethodInitialize {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Class obj = ReflectionClass.class;
        Object o = obj.newInstance();
        Method[] methods = obj.getMethods();
        for (Method method : methods){
            method.invoke(o);
        }
    }
}
