package concepts.sorting;

import java.util.ArrayList;

public class SortMain {
    public static void main(String[] args) {
        int arr[] = {10,2, 0, 3, 1, 9, 3};
//        insertionSort(arr);
//        mergeSort(0, arr.length - 1, arr);
        quickSort(0, arr.length - 1, arr);
        System.out.println(arr);
    }

    public static void quickSort(int start, int end, int[] arr) {
        if (start < end) {
            int pi = partition(start, end, arr);
            quickSort(start, pi - 1, arr);
            quickSort(pi + 1, end, arr);
        }
    }

    public static int partition(int start, int end, int[] arr) {
        int pivot = arr[start];
        int k = end;
        for (int i = end; i > start; i--) {
            if (arr[i] > pivot) {
                int tmp = arr[k];
                arr[k] = arr[i];
                arr[i] = tmp;
                k--;
            }
        }
        int tmp = arr[k];
        arr[k] = arr[start];
        arr[start] = tmp;
        return k;
    }

    public static void mergeSort(int start, int end, int[] arr) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid, arr);
            mergeSort(mid + 1, end, arr);
            merge(start, mid, end, arr);
        }
    }

    public static void merge(int start, int mid, int end, int[] arr) {
        int left = start;
        int right = mid + 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }
        while (right <= end) {
            list.add(arr[right]);
            right++;
        }
        for (int i = start; i <= end; i++) {
            arr[i] = list.get(i - start);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
        System.out.println(arr);
    }
}
