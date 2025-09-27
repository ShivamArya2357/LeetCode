package Practice.src.warmup;

public class LeetCode419 {

    public static void main(String[] args) {

        LeetCode419 test = new LeetCode419();
        char[][] board = new char[][]{{'X','.','X'},{'X','.','X'}};
        int totalBattleShips = test.countBattleships(board);
        System.out.println(totalBattleShips);
    }

//    public int countBattleships(char[][] board) {
//
//        int row = board.length;
//        int col = board[0].length;
//        int totalBattleShips = 0;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (board[i][j] == 'X') {
//                    board[i][j] = 'Y';
//                    totalBattleShips++;
//                    markBattleShipVisited(board, i, j, row, col);
//                }
//            }
//        }
//        return totalBattleShips;
//    }
//
//    private void markBattleShipVisited(char[][] board, int i, int j, int row, int col) {
//
//        for (int k = j + 1; k < col; k++) {
//            if (board[i][k] == 'X') {
//                board[i][k] = 'Y';
//            } else {
//                break;
//            }
//        }
//        for (int k = i + 1; k < row; k++) {
//            if (board[k][j] == 'X') {
//                board[k][j] = 'Y';
//            } else {
//                break;
//            }
//        }
//    }

    public int countBattleships(char[][] board) {

        int row = board.length;
        int col = board[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X' && !isAlreadyIncluded(board, i, j, row, col)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isAlreadyIncluded(char[][] board, int i, int j, int row, int col) {

        return (j - 1 >= 0 && board[i][j - 1] == 'X') || (i - 1 >= 0 && board[i - 1][j] == 'X');
    }
}
