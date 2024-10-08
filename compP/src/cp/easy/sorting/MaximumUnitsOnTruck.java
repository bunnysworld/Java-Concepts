package cp.easy.sorting;

public class MaximumUnitsOnTruck {

    //https://leetcode.com/problems/maximum-units-on-a-truck/
    public static void main(String[] args) {
        int[][] arr = {{2, 1}, {4, 4}, {3, 1}, {4, 1}, {2, 4}, {3, 4}, {1, 3}, {4, 3}, {5, 3}, {5, 3}};
        maximumUnits(arr, 13);
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        sort(boxTypes, 0, boxTypes.length - 1);
        int ans = 0;
        for (int i = boxTypes.length - 1; i >= 0; i--) {
            int[] box = boxTypes[i];
            if (box[0] <= truckSize) {
                ans += box[0] * box[1];
                truckSize -= box[0];
            } else {
                ans += truckSize * box[1];
                break;
            }
        }
        return ans;
    }

    public static void sort(int[][] boxtypes, int low, int high) {
        if (low < high) {
            int pi = partition(boxtypes, low, high);
            sort(boxtypes, low, pi - 1);
            sort(boxtypes, pi + 1, high);
        }
    }

    public static int partition(int[][] arr, int low, int high) {
        int pivot = arr[high][1];
        int k = low;
        for (int i = low; i < high; i++) {
            if (arr[i][1] < pivot) {
                int[] tmp = arr[k];
                arr[k] = arr[i];
                arr[i] = tmp;
                k++;
            }
        }
        int[] tmp = arr[k];
        arr[k] = arr[high];
        arr[high] = tmp;
        return k;
    }

}
