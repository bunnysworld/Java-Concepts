package cp.ltDaily;

public class MinimumStringLengthAfterRemoving {

//    https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/
    public static void main(String[] args) {
        minLength("ABFCACDB");
    }

    public static int minLength(String s) {
        while (true) {
            boolean isAvail = false;
            StringBuilder sb = new StringBuilder();
            int i =0;
            while(i < s.length()){
                if(i == s.length()-1){
                    sb.append(s.charAt(i));
                    i++;
                }else{
                    if((s.charAt(i) == 'A' && s.charAt(i+1) == 'B') ||
                            (s.charAt(i) == 'C' && s.charAt(i+1) =='D')){
                        isAvail = true;
                        i +=2;
                    }else{
                        sb.append(s.charAt(i));
                        i+=1;
                    }
                }
            }
            s = sb.toString();
            if(!isAvail){
                break;
            }
        }
        return s.length();
    }
}
