package concepts.InterFaces.multipleInheritance;

public interface TwoWheeler {
    void applyBreak();

    default void startEngine(){
        System.out.println("Enter Key");
    }
}
