package Practice.src.warmup;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode841 {

    public static void main(String[] args) {


    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            visited[currNode] = true;
            if (rooms.get(currNode) != null && !rooms.get(currNode).isEmpty()) {
                for (Integer neighbour : rooms.get(currNode)) {
                    if (!visited[neighbour]) {
                        queue.add(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
