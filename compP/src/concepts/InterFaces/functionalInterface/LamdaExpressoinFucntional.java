package concepts.InterFaces.functionalInterface;

public class LamdaExpressoinFucntional {
    public static void main(String[] args) {
        Drive car = () -> {
            System.out.println("Drive car");
        };
        car.drive();

    }
}
