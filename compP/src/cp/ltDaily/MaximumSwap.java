package cp.ltDaily;

public class MaximumSwap {
    public static void main(String[] args) {
        maximumSwap(98368);
    }

    public static int maximumSwap(int num) {
        char[] numArr = String.valueOf(num).toCharArray();
        int n = numArr.length;
        int[] rightMaxIndexArr = new int[n];
        rightMaxIndexArr[n-1] = n-1;
        for(int i=n-2;i>=0;i--){
            rightMaxIndexArr[i] = (numArr[i] > rightMaxIndexArr[i+1])
                    ? i
                    : rightMaxIndexArr[i+1];
        }
        for(int i=0;i<n;i++){
            if(numArr[i] < numArr[rightMaxIndexArr[i]]){
                char c = numArr[i];
                numArr[i] = numArr[rightMaxIndexArr[i]];
                numArr[rightMaxIndexArr[i]] = c;
                return Integer.parseInt(new String(numArr));
            }
        }
        return num;
    }
}
