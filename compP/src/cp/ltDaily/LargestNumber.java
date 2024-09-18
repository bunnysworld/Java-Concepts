package cp.ltDaily;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        largestNumber(new int[]{1, 2, 3});
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
