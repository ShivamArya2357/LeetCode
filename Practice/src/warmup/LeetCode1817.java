package Practice.src.warmup;

import java.util.*;

public class LeetCode1817 {

    public static void main(String[] args) {

        int[][] logs = new int[][]{
                {0,5},{1,2},{0,2},{0,5},{1,3}
        };
        int k = 5;
        int[] res = findingUsersActiveMinutes(logs, k);
    }

    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {

        int[] res = new int[k];
        int logSize = logs.length;
        Set<UserInfo> set = new HashSet<>();
        Map<Integer, Integer> uamMap = new HashMap<>();
        for (int i = 0; i < logSize; i++) {
            int userId = logs[i][0];
            int minute = logs[i][1];
            UserInfo userInfo = new UserInfo(userId, minute);
            if (!set.contains(userInfo)) {
                uamMap.put(userId, uamMap.getOrDefault(userId, 0) + 1);
                set.add(userInfo);
            }
        }
        for (Map.Entry<Integer, Integer> entry : uamMap.entrySet()) {
            res[entry.getValue() - 1]++;
        }
        return res;
    }

    static class UserInfo {

        private int userId;

        private int minute;

        public UserInfo(int userId, int minute) {
            this.userId = userId;
            this.minute = minute;
        }

        // Override equals to compare userId and minute
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            UserInfo userInfo = (UserInfo) obj;
            return userId == userInfo.userId && minute == userInfo.minute;
        }

        // Override hashCode to compute hash based on userId and minute
        @Override
        public int hashCode() {
            return Objects.hash(userId, minute);
        }
    }
}
