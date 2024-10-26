package concepts.ComparatorComparable;

import java.util.Arrays;

public class ComparatorMain {
    public static void main(String[] args) {
        Integer[] arr = {2, 3, 1, 5};
//        Arrays.sort(arr, (a1, a2) -> a1 - a2);
        Arrays.sort(arr, (a1, a2) -> a2 - a1);

        StudentComparator[] student = {new StudentComparator("test", 23), new StudentComparator("wer", 21)};
        Arrays.sort(student, new StudentComparator());
        System.out.println(student);
    }
}
