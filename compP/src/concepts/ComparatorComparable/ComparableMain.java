package concepts.ComparatorComparable;

import java.util.Arrays;

public class ComparableMain {
    public static void main(String[] args) {
        StudentComparable[] students = {new StudentComparable("df", 20),
                new StudentComparable("fd", 10)};

        Arrays.sort(students, (s1, s2) -> s1.compareTo(s2));

        System.out.println(students);

    }
}
