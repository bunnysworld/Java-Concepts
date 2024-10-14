package concepts.generic;

public class GenericUpperBound {

    class Animal {
        public int dosesForVaccinated() {
            return 0;
        }
    }

    class Dog extends Animal {
        @Override
        public int dosesForVaccinated() {
            return 2;
        }
    }

    class Cat extends Animal {
        @Override
        public int dosesForVaccinated() {
            return 3;
        }
    }

    class Veterinarian<T extends Animal> {
        public void applyingDoses(T animal) {
            System.out.println(animal.dosesForVaccinated());
        }
    }

    public void main(String[] args) {
        Dog dog = new Dog();
        Veterinarian<Dog> d = new Veterinarian<>();
        d.applyingDoses(dog);

        Cat cat = new Cat();
        Veterinarian<Cat> c = new Veterinarian<>();
        c.applyingDoses(cat);
    }
}
