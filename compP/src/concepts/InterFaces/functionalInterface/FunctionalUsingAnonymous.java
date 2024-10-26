package concepts.InterFaces.functionalInterface;

public class FunctionalUsingAnonymous {
    public static void main(String[] args) {
        Drive car = new Drive() {
            @Override
            public void drive() {
                System.out.println("Drive a car");
            }
        };
        car.drive();
    }
}
