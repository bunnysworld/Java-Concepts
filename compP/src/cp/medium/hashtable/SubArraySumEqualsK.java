package cp.medium.hashtable;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    //https://leetcode.com/problems/subarray-sum-equals-k/

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        subarraySum(arr, 2);
    }

    public static int subarraySum_1(int[] nums, int k) { //O(n^2)
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    // using prefix sum and hashmap
    public static int subarraySum(int[] nums, int k) { // tc -> O(nlogn) space -> O(n)
        int count = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefixSumMap.containsKey(sum - k)) {
                count += prefixSumMap.get(sum - k);
            }
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
