package Practice.src.warmup;

public class LeetCode1861 {

    public static void main(String[] args) {

        LeetCode1861 test = new LeetCode1861();
        char[][] boxGrid = {{'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'}
        };
        char[][] ans = test.rotateTheBox(boxGrid);
        int R = ans.length;
        int C = ans[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public char[][] rotateTheBox(char[][] boxGrid) {

        int R = boxGrid.length;
        int C = boxGrid[0].length;
        char[][] ans = new char[C][R];
        for (int i = R - 1; i >= 0; i--) {
            int stoneCount = 0;
            for (int j = 0; j < C; j++) {
                if (boxGrid[i][j] == '#') {
                    boxGrid[i][j] = '.';
                    stoneCount++;
                } else if (boxGrid[i][j] == '*') {
                    int x = i;
                    int y = j - 1;
                    while (y >= 0 && stoneCount > 0) {
                        boxGrid[x][y] = '#';
                        y--;
                        stoneCount--;
                    }
                }
            }
            if (stoneCount > 0) {
                int x = i;
                int y = C - 1;
                while (y >= 0 && stoneCount > 0) {
                    boxGrid[x][y] = '#';
                    y--;
                    stoneCount--;
                }
            }
        }
        int y = 0;
        for (int i = R - 1; i >= 0; i--,y++) {
            int x = 0;
            for (int j = 0; j < C; j++,x++) {
                ans[x][y] = boxGrid[i][j];
            }
        }
        return ans;
    }
}
