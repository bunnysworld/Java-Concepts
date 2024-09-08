package concepts.abstractExample;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    @Override
    String features() {
        return "I have 4 legs";
    }
}
