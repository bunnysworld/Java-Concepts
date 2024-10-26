package concepts.InterFaces.multipleInheritance;

public interface FourWheeler {
    void applyBreak();

    default void startEngine(){
        System.out.println("Enter Key");
    }
}
