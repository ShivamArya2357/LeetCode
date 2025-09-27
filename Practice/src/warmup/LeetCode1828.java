package Practice.src.warmup;

public class LeetCode1828 {

    public static void main(String[] args) {

        LeetCode1828 test = new LeetCode1828();
        int[][] points = new int[][]{{1,3},{3,3},{5,3},{2,2}};
        int[][] queries = new int[][]{{2,3,1},{4,3,1},{1,1,2}};
        int[] output = test.countPoints(points, queries);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }

    public int[] countPoints(int[][] points, int[][] queries) {

        int queryLen = queries.length;
        int pointLen = points.length;
        int[] output = new int[queryLen];
        for (int i = 0; i < queryLen; i++) {
            int centerX = queries[i][0];
            int centerY = queries[i][1];
            int radius = queries[i][2];
            int count = 0;
            for (int j = 0; j < pointLen; j++) {
                int x = points[j][0];
                int y = points[j][1];
                if (isPointInsideTheCircle(centerX, centerY, radius, x, y)) {
                    count++;
                }
            }
            output[i] = count;
        }
        return output;
    }

    private boolean isPointInsideTheCircle(int centerX, int centerY, int radius, int x, int y) {
        return (x - centerX) * (x - centerX) + (y - centerY) * (y - centerY) - radius * radius <= 0;
    }
}
