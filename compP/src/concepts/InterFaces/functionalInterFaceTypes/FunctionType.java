package concepts.InterFaces.functionalInterFaceTypes;

import java.util.function.Function;

public class FunctionType {
    public static void main(String[] args) {
        Function<String, Integer> function = (a) -> {
            a = a + 2;
            return Integer.parseInt(a);
        };

        System.out.println(function.apply("1"));
    }
}
