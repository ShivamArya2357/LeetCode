package Practice.src.warmup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode1198 {

    public static void main(String[] args) {

        LeetCode1198 test = new LeetCode1198();
        int[][] mat = {{1, 2, 3},
                {4, 5, 6}};
        int ans = test.findSmallestCommonElement(mat);
        System.out.println(ans);
    };

    public int findSmallestCommonElement(int[][] mat) {

        int R = mat.length;
        int C = mat[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int element = mat[i][j];
                map.put(element, map.getOrDefault(element, 0) + 1);
            }
        }
        int element = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == R) {
                element = Math.min(element, entry.getKey());
            }
        }
        if (element == Integer.MAX_VALUE) {
            return -1;
        } else {
            return element;
        }
    }
}
