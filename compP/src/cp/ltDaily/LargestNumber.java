package cp.ltDaily;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        largestNumberUsingMergeSort(new int[]{3, 30, 34, 5, 9});
    }

    public static String largestNumberUsingMergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        if (nums[0] == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if (low == high)
            return;
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;
        int[] L = new int[leftSize];
        int[] R = new int[rightSize];
        for (int i = 0; i < leftSize; i++) {
            L[i] = nums[i + low];
        }
        for (int j = 0; j < rightSize; j++) {
            R[j] = nums[j + mid + 1];
        }
        int i = 0;
        int j = 0;
        int k = low;
        while (i < leftSize && j < rightSize) {
            String v1 = String.valueOf(L[i]) + R[j];
            String v2 = String.valueOf(R[j]) + L[i];
            int v = v1.compareTo(v2);
            if (v > 0) {
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            nums[k] = L[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }

    public static String largestNumber(int[] nums) {
        String[] element = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            element[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(element, new Comparator<String>() {
            public int compare(String v1, String v2) {
                String f = v1 + v2;
                String s = v2 + v1;
                return s.compareTo(s);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < element.length; i++) {
            builder.append(element[i]);
        }
        return builder.toString();
    }
}
