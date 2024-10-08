package cp.ltDaily;

import java.util.Stack;

public class MinimumNumberOfSwaps {

//    https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/?envType=daily-question&envId=2024-10-08
    public static void main(String[] args) {
        minSwaps("]]]][[[[");
    }

    public static int minSwaps(String s) {
        int extraClosingBrackets=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']'){
                extraClosingBrackets++;
                max=Math.max(max, extraClosingBrackets);
            }
            else{
                extraClosingBrackets--;
            }
        }
        return (max+1)/2;
    }
}
