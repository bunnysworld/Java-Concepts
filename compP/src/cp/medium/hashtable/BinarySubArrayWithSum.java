package cp.medium.hashtable;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArrayWithSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        numSubarraysWithSum(nums, 2);
    }

    public static int numSubarraysWithSum_1(int[] nums, int goal) { //tc -> O(n^2) , sc -> O(1)
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == goal)
                    count++;
                else if (sum > goal)
                    break;
            }
        }
        return count;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) { //tc -> O(nlogn) , sc -> O(n)
        int count = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefixSumMap.containsKey(sum - goal)) {
                count += prefixSumMap.get(sum - goal);
            }
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
