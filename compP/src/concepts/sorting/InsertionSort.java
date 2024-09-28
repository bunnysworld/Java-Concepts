package concepts.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2, 12, 4, 89, 34, 21};
        insertionSort(arr);
        System.out.println(arr);
    }

    public static void insertionSort(int[] arr) { // tc -> 0(n^2)
        for (int i = 0; i <= arr.length - 2; i++) {
            int min = i;
            for (int j = i; j <= arr.length - 1; j++) {
                if (arr[j] < arr[i])
                    min = j;
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }
}
