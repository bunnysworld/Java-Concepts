package cp.ltDaily;

public class FindKthBitInNBinary {
    public static void main(String[] args) {
        char c = findKthBit(4,11);
    }

    public static char findKthBit(int n, int k) {
        int len = (int)Math.pow(2,n)-1;
        return recur(len,k);
    }

    public static char recur(int len,int k){
        if(k == 1)
            return '0';
        int middle = (len/2)+1;
        if(middle == k){
            return '1';
        }else if(k < middle){
            return recur(middle-1,k);
        }else{
            char ch = recur(middle-1,len-k+1);
            return (ch == '0') ? '1' : '0';
        }
    }

    public char findKthBit_1(int n, int k) {// tc-> 2^n sc -> 2^n
        StringBuilder sb = new StringBuilder("0");
        for (int i = 1; i < n && k > sb.length(); i++) {
            sb.append("1");
            for (int j = sb.length() - 2; j >= 0; j--) {
                char c = sb.charAt(j) == '0' ? '1' : '0';
                sb.append(c);
            }
        }
        return sb.charAt(k - 1);
    }
}
