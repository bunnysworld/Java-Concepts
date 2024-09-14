package cp.ltDaily;

public class MaxBitWiseAnd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 2};
        longestSubarray(arr);
    }

    public static int longestSubarray(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer and = null;
            for (int j = i; j < nums.length; j++) {
                if (and == null) {
                    and = nums[j];
                } else {
                    and = nums[j] & and;
                }
                if (and == 0)
                    break;
                if (and > max) {
                    max = and;
                    count = j - i + 1;
                } else if (and == max) {
                    count = Math.max(count, j - i + 1);
                }
            }
        }
        return count;
    }
}
