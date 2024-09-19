package concepts.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int leftSize = mid - l + 1;
        int rightSize = r - mid;

        int[] L = new int[leftSize];
        int[] R = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < rightSize; j++) {
            R[j] = arr[j + mid + 1];
        }

        int i = 0;
        int j = 0; // initial indices for i and j
        int k = l; // indices for merged array
        while (i < leftSize && j < rightSize) {
            if (L[i] >= R[j]) {
                arr[k] = R[j];
                j++;
            } else {
                arr[k] = L[i];
                i++;
            }
            k++;
        }

        // copy remaining element
        while (i < leftSize) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
