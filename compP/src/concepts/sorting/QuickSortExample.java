package concepts.sorting;

public class QuickSortExample {
    public static void main(String[] args) {
        int[] arr = {8, 3, 11, 22, 6, 1, 10};
//        partitionWithFirstElement(arr,0,arr.length-1);
//        partitionWithLastElement(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        System.out.println("vfv");
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionWithLastElement(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partitionWithFirstElement(int[] arr, int low, int high) { // return the exact index of the pivoted value
        int pivot = arr[low];
        int k = high;
        for (int i = high; i > low; i--) {
            if (arr[i] > pivot) {
                swap(arr, i, k);
                k--;
            }
        }
        swap(arr, low, k);
        return k;
    }

    private static int partitionWithLastElement(int[] arr, int low, int high) { // take pivot the last element
        int pivot = arr[high];
        int k = low;
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, k);
                k++;
            }
        }
        swap(arr, high, k);
        return k;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}
