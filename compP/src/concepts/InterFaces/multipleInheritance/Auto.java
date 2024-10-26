package concepts.InterFaces.multipleInheritance;

public class Auto implements FourWheeler, TwoWheeler {

    @Override
    public void applyBreak() {
        // apply break for auto
    }

    @Override
    public void startEngine() {
        FourWheeler.super.startEngine();
    }
}
