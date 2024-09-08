package concepts.abstractExample;

public abstract class Animal {
    String name;
    public Animal(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    abstract String features();
}
