package concepts.ComparatorComparable;

import java.util.Comparator;

public class StudentComparator implements Comparator<StudentComparator> {
    String name;
    int age;

    public StudentComparator(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public StudentComparator() {
    }

    @Override
    public int compare(StudentComparator o1, StudentComparator o2) {
        return o1.age - o2.age;
    }

}
