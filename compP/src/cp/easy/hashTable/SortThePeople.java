package cp.easy.hashTable;

import java.util.TreeMap;

public class SortThePeople {

    //https://leetcode.com/problems/sort-the-people/description/

    public static void main(String[] args) {
        int[] height = {155,185,150};
        String[] names = {"Alice","Bob","Bob"};
        System.out.println(sortPeople(names,height));
    }

    public static String[] sortPeople(String[] names, int[] heights) { // using quick sort in descending order
        quickSort(heights, names, 0, heights.length - 1);
        return names;
    }

    public static void quickSort(int[] heights, String[] names, int low, int end) {
        if (low < end) {
            int pi = partition(heights, names, low, end);
            quickSort(heights, names, 0, pi - 1);
            quickSort(heights, names, pi + 1, end);
        }
    }

    private static int partition(int[] heights, String[] names, int low, int end) { // move smaller element to right and greater to the left
        int pivot = heights[low];
        int high = end;
        for (int i = high; i > low; i--) {
            if (heights[i] < pivot) {
                swap(heights, names, i, high);
                high--;
            }
        }
        swap(heights, names, low, high);
        return high;
    }

    private static void swap(int[] heights, String[] names, int i, int j) {
        int tmp = heights[j];
        heights[j] = heights[i];
        heights[i] = tmp;

        String n = names[j];
        names[j] = names[i];
        names[i] = n;
    }

    public String[] sortPeople_1(String[] names, int[] heights) { // using treeMap time complexity O(2nlogn) space complexity O(2n)
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < heights.length; i++) { // n time
            treeMap.put(heights[i], i); // entry logn
        }
        // nLogn
        String[] ans = new String[names.length];
        int i = 0;
        while (treeMap.size() > 0) {//n
            ans[i] = names[treeMap.pollLastEntry().getValue()]; // Logn
            i++;
        }
        return ans;
    }
}
