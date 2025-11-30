package Practice.src.warmup;

import java.util.*;

public class LeetCode2610 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> findMatrix(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        while (map.size() > 0) {
            List<Integer> temp = new ArrayList<>();
            Iterator<Map.Entry<Integer, Integer> > itr = map.entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry<Integer, Integer> entry = itr.next();
                temp.add(entry.getKey());
                if (entry.getValue() < 2) {
                    itr.remove();
                } else {
                    entry.setValue(entry.getValue() - 1);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
