package concepts.ComparatorComparable;

public class StudentComparable implements Comparable<StudentComparable> {

    String name;

    int age;

    public StudentComparable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(StudentComparable s1) {
        return this.age - s1.age;
    }
}
