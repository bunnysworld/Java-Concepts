package cp.ltDaily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnCommonWords {
    public static void main(String[] args) {
        uncommonFromSentences("apple apple","banana");
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        Set<String> uq1 = getUniqueWord(s1);
        Set<String> uq2 = getUniqueWord(s2);
        List<String> ans = new ArrayList<>();
        if (uq1.size() == 0 && uq1.size() == 0) {
            return new String[0];
        } else if (uq1.size() == 0 && uq2.size() > 0)
            return uq2.toArray(new String[uq2.size()]);
        else if (uq2.size() == 0 && uq1.size() > 0)
            return uq1.toArray(new String[uq1.size()]);
        for (String us : uq1) {
            if (!uq2.contains(us)) {
                ans.add(us);
            } else {
                uq2.remove(us);
            }
        }
        for (String us : uq2) {
            ans.add(us);
        }
        return ans.toArray(new String[ans.size()]);
    }

    public static Set<String> getUniqueWord(String w) {
        Set<String> uniqueWord = new HashSet<>();
        Set<String> ignoreWord = new HashSet();
        for (String s : w.split(" ")) {
            if (uniqueWord.contains(s)) {
                ignoreWord.add(s);
                uniqueWord.remove(s);
            } else {
                if (!ignoreWord.contains(s)) {
                    uniqueWord.add(s);
                }
            }
        }
        return uniqueWord;
    }
}
