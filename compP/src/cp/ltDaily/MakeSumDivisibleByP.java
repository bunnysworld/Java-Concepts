package cp.ltDaily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/make-sum-divisible-by-p/?envType=daily-question&envId=2024-10-03
public class MakeSumDivisibleByP {
    public static void main(String[] args) {
        int[] arr = {1000000000,1000000000,1000000000};
        minSubarray(arr, 3);
    }

    public static int minSubarray(int[] nums,int p){
        long sum = 0;
        for(int i = 0; i<nums.length;i++){
            sum += nums[i];
        }
        int target = (int)(sum % p);
        if(target == 0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap();
        map.put(0,-1);
        sum = 0;
        int size = nums.length;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int currRem = (int)(sum % p);
            int searchFor = currRem - target;
            if(searchFor < 0){
                searchFor += p;
            }
            if(map.containsKey(searchFor)){
                size = Math.min(size,i-map.get(searchFor));
            }
            map.put(currRem,i);
        }

        return size == nums.length ? -1 : size;
    }

    // public int minSubarray(int[] nums, int p) { // n+n^2 // sc -> 0(1) gives TLE
    //     long sum = Arrays.stream(nums).asLongStream().sum(); // n
    //     if(sum < p){
    //         return -1;
    //     }
    //     int reminder = (int) (sum % p);
    //     if(reminder == 0)
    //         return 0;
    //     int size = Integer.MAX_VALUE;
    //     for(int i=0;i<nums.length;i++){ // n^2
    //         int s = 0;
    //         for(int j = i;j<nums.length;j++){
    //             s+=nums[j];
    //             if(s % p == reminder)
    //                 size = Math.min(size,j-i+1);
    //         }
    //     }
    //     if(size == Integer.MAX_VALUE || size == nums.length)
    //         return -1;
    //     return size;
    // }
}
