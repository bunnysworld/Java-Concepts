package concepts.dsa.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(1,1);
        treeMap.put(2,2);
        treeMap.put(3,4);
        while (treeMap.size() > 0){
            System.out.println(treeMap.pollLastEntry().getValue());
        }

    }
}
