package cp.ltDaily;

public class MAximumWidthRamp {

//    https://leetcode.com/problems/maximum-width-ramp/?envType=daily-question&envId=2024-10-10

    public static void main(String[] args) {
        int[] arr = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        maxWidthRamp(arr);
    }

    public static int maxWidthRamp(int[] nums) { // optimize
        int n = nums.length;
        int[] rMax = new int[n];
        rMax[n-1] = nums[n-1];
        for(int i = n-2;i>=0;i--){
            rMax[i] = Math.max(rMax[i+1],nums[i]);
        }
        int maxLen = 0;
        int i = 0;
        int j = 0;
        while(j < n){
            while(i < j && nums[i] > rMax[j]){
                i++;
            }
            maxLen = Math.max(maxLen,j-i);
            j++;
        }
        return maxLen;
    }

    public static int maxWidthRamp1(int[] nums) { // tc -> n^2 // sc->0(1)
        int maxLen = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums.length-1-i < maxLen)
                break;
            for(int j=nums.length-1;j>0;j--){
                if(nums[j] >= nums[i]){
                    maxLen = Math.max(maxLen,j-i);
                    break;
                }
            }
        }
        return maxLen;
    }

}
