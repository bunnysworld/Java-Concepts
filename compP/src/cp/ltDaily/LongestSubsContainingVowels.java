package cp.ltDaily;

import java.util.HashMap;
import java.util.Map;

public class LongestSubsContainingVowels {
    public static void main(String[] args) {
        findTheLongestSubstring("leetcodeisgreat");
    }

    public static int findTheLongestSubstring_1(String s) { // tc -> 0(n^2) sc -> 0(5) throw tle
        int maxSize = 0;
        for (int i = 0; i < s.length(); i++) {
            int arr[] = new int[5];
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (ch == 'a')
                    arr[0]++;
                else if (ch == 'e')
                    arr[1]++;
                else if (ch == 'i')
                    arr[2]++;
                else if (ch == 'o')
                    arr[3]++;
                else if (ch == 'u')
                    arr[4]++;
                if (arr[0] % 2 == 0 && arr[1] % 2 == 0 && arr[2] % 2 == 0 && arr[3] % 2 == 0 && arr[4] % 2 == 0) {
                    maxSize = Math.max(maxSize, j - i + 1);
                }
            }
        }
        return maxSize;
    }


    public static int findTheLongestSubstring(String s) {
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        String currState = "00000";
        map.put(currState, -1);
        int[] state = new int[5];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a')
                state[0] = (state[0] + 1) % 2;
            else if (ch == 'e')
                state[1] = (state[1] + 1) % 2;
            else if (ch == 'i')
                state[2] = (state[2] + 1) % 2;
            else if (ch == 'o')
                state[3] = (state[3] + 1) % 2;
            else if (ch == 'u')
                state[4] = (state[4] + 1) % 2;

            currState = "";
            for (int j = 0; j < 5; j++) {
                currState += String.valueOf(state[j]);
            }
            if (map.containsKey(currState)) {
                max = Math.max(max, i - map.get(currState));
            } else {
                map.put(currState, i);
            }
        }
        return max;
    }
}
