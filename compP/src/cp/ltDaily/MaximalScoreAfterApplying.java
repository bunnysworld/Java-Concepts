package cp.ltDaily;

import java.util.PriorityQueue;

public class MaximalScoreAfterApplying {
    public static void main(String[] args) {
        maxKelements(new int[]{1, 10, 3, 3, 3}, 3);
    }

    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for (int no : nums) {
            queue.add(no);
        }
        long score = 0;
        while (k > 0) {
            int no = queue.poll();
            score += no;
            queue.offer((int) Math.ceil((double) no / 3));
            k--;
        }
        return score;
    }
}
