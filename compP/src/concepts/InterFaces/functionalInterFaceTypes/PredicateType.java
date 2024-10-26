package concepts.InterFaces.functionalInterFaceTypes;

import java.util.function.Predicate;

public class PredicateType {
    public static void main(String[] args) {
        Predicate<String> predicate = (a)->{
            return a.equalsIgnoreCase("abc");
        };

        System.out.println(predicate.test("abc"));
    }
}
