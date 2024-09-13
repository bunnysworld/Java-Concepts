package cp.ltDaily;

public class Xor1310 {
    // https://leetcode.com/problems/xor-queries-of-a-subarray/description/?envType=daily-question&envId=2024-09-13
    public static void main(String[] args) {
        int[] arr ={4,8,2,10};
        int[][] queries = {{2, 3}, {1, 3}, {0, 0}, {0, 3}};
        xorQueries(arr, queries);
    }

    public static int[] xorQueries_1(int[] arr, int[][] queries) { // tc -> 0(n^2) sc -> 0(n)
        int[] sum = new int[queries.length];
        int index = 0;
        for (int[] ar : queries){
            int xor = 0;
            for (int i = ar[0];i<=ar[1];i++){
                xor ^= arr[i];
            }
            sum[index] = xor;
            index++;
        }
        return sum;
    }

    public static int[] xorQueries(int[] arr, int[][] queries) { //tc -> 0(n+q) sc -> 0(n)
        int[] sum = new int[arr.length];
        int[] ans = new int[queries.length];
        sum[0] = arr[0];
        for (int i = 1;i<arr.length;i++){
            sum[i] = arr[i] ^ sum[i-1];
        }
        int index = 0;
        for (int[] ar : queries){
            if (ar[0]-1 < 0)
                ans[index] = sum[ar[1]];
            else
                ans[index] = sum[ar[0]-1] ^ sum[ar[1]];
            index++;
        }
        return ans;
    }

}
