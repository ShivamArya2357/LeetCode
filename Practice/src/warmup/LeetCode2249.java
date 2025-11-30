package Practice.src.warmup;

import java.util.HashSet;
import java.util.Set;

public class LeetCode2249 {

    public static void main(String[] args) {

    }

    public int countLatticePoints(int[][] circles) {

        Set<String> set = new HashSet<>();
        for (int[] circle : circles) {
            int x = circle[0];
            int y = circle[1];
            int radius = circle[2];
            for (int X = x - radius; X <= x + radius; X++) {
                for (int Y = y - radius; Y <= y + radius; Y++) {
                    if (isPointInsideTheCircle(x, y, radius, X, Y)) {
                        set.add(X + "," + Y);
                    }
                }
            }
        }
        return set.size();
    }

    private boolean isPointInsideTheCircle(int x, int y, int radius, int X, int Y) {
        return (x - X) * (x - X) + (y - Y) * (y - Y) - radius * radius <= 0;
    }
}
