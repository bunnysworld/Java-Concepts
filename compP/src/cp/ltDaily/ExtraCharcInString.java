package cp.ltDaily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtraCharcInString {
    public static void main(String[] args) {
        String[] dict = {"leet", "code", "leetcode"};
        System.out.println(minExtraChar("leetscode", dict));
    }

//    static int[] dp = new int[50];

    public static int minExtraChar(String s, String[] dict) {
        Set<String> d = new HashSet(Arrays.asList(dict));
//        Arrays.fill(dp, -1);
        return recurr(s, d, 0);
    }

    public static int recurr(String s, Set<String> set, int index) {
        if (s.length() == index) {
            return 0;
        }
//        if (dp[index] != -1) {
//            return dp[index];
//        }
        StringBuilder sb = new StringBuilder();
        int minExtraChar = Integer.MAX_VALUE;
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            int extraChar = 0;
            if (!set.contains(sb.toString())) {
                extraChar = sb.length();
            }
            int currExtraChar = recurr(s, set, i + 1);
            minExtraChar = Math.min(minExtraChar, extraChar + currExtraChar);
        }
        return minExtraChar;
    }
}
