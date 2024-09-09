package cp.easy.hashTable;

public class CommonElementsBetweenTwo {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-common-elements-between-two-arrays/description/
        int[] arr1 = {4,3,2,3,1};
        int[] arr2 = {2,2,5,2,3,6};
        findIntersectionValues(arr1,arr2);
    }

    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] map1 = new int[101];
        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums1) {
            map1[num]++;
        }
        for (int num : nums2) {
            if (map1[num] != 0) {
                sum2++;
                if (map1[num] > 0) {
                    sum1 += map1[num];
                    map1[num] = -map1[num];
                }
            }
        }
        return new int[] { sum1, sum2 };
    }
}
