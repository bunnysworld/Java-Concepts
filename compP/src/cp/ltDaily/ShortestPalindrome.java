package cp.ltDaily;

public class ShortestPalindrome {
    public static void main(String[] args) {
        shortestPalindrome("aacecaaa");
    }

    public static String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        for(int i=0;i<s.length();i++){
            if(s.substring(0,s.length()-i).equals(rev.substring(i))){
                return rev.substring(0,i)+s;
            }
        }
        return rev+s;
    }
}
