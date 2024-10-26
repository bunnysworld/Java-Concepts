package concepts.InterFaces.functionalInterFaceTypes;

import java.util.function.Supplier;

public class SupplierType {
    public static void main(String[] args) {
        Supplier<String> supplier = ()->{
            int a=1;
            int b=2;
            return "this is supplier"+a+b;
        };

        System.out.println(supplier.get());
    }
}
