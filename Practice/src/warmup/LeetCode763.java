package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode763 {

    public static void main(String[] args) {

        LeetCode763 test = new LeetCode763();
        List<Integer> ans = test.partitionLabels("eccbbbbdec");
        System.out.println(ans);
    }

    public List<Integer> partitionLabels(String s) {

        int len = s.length();
        int[] lastOccurrence = new int[26];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < len; ) {
            int first = i;
            int last = lastOccurrence[s.charAt(i) - 'a'];
            i++;
            while (i <= last) {
                if (lastOccurrence[s.charAt(i) - 'a'] > last) {
                    last = lastOccurrence[s.charAt(i) - 'a'];
                }
                i++;
            }
            ans.add(last - first + 1);
        }
        return ans;
    }
}
