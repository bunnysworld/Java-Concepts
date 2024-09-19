package cp.ltDaily;

import java.util.ArrayList;
import java.util.List;

public class DifferetWaysToAddParanthesis {
    //https://leetcode.com/problems/different-ways-to-add-parentheses/description/?envType=daily-question&envId=2024-09-19

    public static void main(String[] args) {
        diffWaysToCompute("2*3-4*5");
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }

    public static List<Integer> solve(String s) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left_ans = solve(s.substring(0,i));
                List<Integer> right_ans = solve(s.substring(i+1));

                for(int leftNo : left_ans){
                    for(int rightNo : right_ans){
                        if(c == '+')
                            ans.add(leftNo + rightNo);
                        else if(c == '-')
                            ans.add(leftNo - rightNo);
                        else
                            ans.add(leftNo * rightNo);
                    }
                }
            }
        }
        if(ans.size() == 0)
            ans.add(Integer.parseInt(s));
        return ans;
    }
}
