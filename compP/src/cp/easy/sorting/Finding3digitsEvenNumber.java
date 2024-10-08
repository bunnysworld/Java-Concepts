package cp.easy.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Finding3digitsEvenNumber {
    public static void main(String[] args) {
        int[] arr = {2,1,3,0};
        findEvenNumbers(arr);
    }

    public static int[] findEvenNumbers(int[] digits) {
        Map<Integer,Integer> map = new HashMap();
        for(int i : digits){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> ans = new ArrayList();
        for(int i = 100;i<=998;i+=2){
            Map<Integer,Integer> tmpMap = new HashMap(map);
            int tmp = i;
            while(tmp > 0){
                int rem = tmp % 10;
                if(!tmpMap.containsKey(rem) || tmpMap.get(rem) == 0){
                    break;
                }
                tmpMap.put(rem,tmpMap.get(rem)-1);
                tmp = tmp/10;
            }
            if(tmp == 0){
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
