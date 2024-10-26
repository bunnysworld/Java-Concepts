package concepts.InterFaces.functionalInterFaceTypes;

import java.util.function.Consumer;

public class ConsumerTye {
    public static void main(String[] args) {
        Consumer<String> consumer = (String a)->{
            System.out.println("do some thing with "+a);
        };
        consumer.accept("me");
    }
}
