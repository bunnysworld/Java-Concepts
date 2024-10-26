package concepts.sorting;

import java.util.ArrayList;

public class MergeSort2 {
    public static int count = 0;

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(mergeSort(0, arr.length - 1, arr));
    }

    public static int mergeSort(int start, int end, int[] arr) {
        int cnt = 0;
        if (start < end) {
            int mid = (start + end) / 2;
            cnt += mergeSort(start, mid, arr);
            cnt += mergeSort(mid + 1, end, arr);
            cnt += merge(start, mid, end, arr);
        }
        return cnt;
    }

    public static int merge(int start, int mid, int end, int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = start;
        int right = mid + 1;

        int cnt = 0;
        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                cnt += mid - left + 1;
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
        return cnt;
    }


}
