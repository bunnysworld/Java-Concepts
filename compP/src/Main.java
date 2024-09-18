import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
//        Map<String,String> map = new HashMap<>();
//        map.put("a","b");
//        Collection<String> li = map.values();
//
//        System.out.println("vf");

        int[] arr1 = {-80,-15,-81,-28,-61,63,14,-45,-35,-10};
        int[] arr2 = {-1,-40,-44,41,10,-43,69,10,2};
        findDifference(arr1,arr2);
    }

    // [-1,2,69,-40,41,10,-43,-44]

    // [-1,-40,-44,41,10,-43,69,10,2]
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet();
        for(int no : nums1){
            set1.add(no);
        }
        Set<Integer> set2 = new HashSet();
        List<Integer> list2 = new ArrayList();
        for(int no : nums2){
            if(!set1.contains(no) && !set1.contains(no*-1)){
                list2.add(no);
            }
            set2.add(no);
        }
        List<Integer> list1 = new ArrayList();
        for(int no : set1){
            if(!set2.contains(no)){
                list1.add(no);
            }
        }
        List<List<Integer>> ans = new ArrayList();
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}