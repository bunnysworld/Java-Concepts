package concepts.claZses;

import java.util.Objects;

public class AnonymousClass {

    // using interface
    interface Printable {
        void print();

        void getPrint();
    }

    // using abstract class
    abstract static class Shape {
        abstract void shapeType();
    }

    public static void main(String[] args) {

        // one time used object
        Object obj = new Object(){
            public String toString(){
                return "I am object";
            }
        };
        System.out.println(obj);

        // abstract class
        Shape circle = new Shape() {
            @Override
            void shapeType() {
                System.out.println("Type circle");
            }
        };
        circle.shapeType();

        // interface type
        Printable printable = new Printable() {
            @Override
            public void print() {
                System.out.println("Print some thing");
            }

            @Override
            public void getPrint() {

            }
        };
        printable.print();
    }
}
