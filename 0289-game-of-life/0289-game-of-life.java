class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = countLive(board, i, j, m, n);
                if (board[i][j] == 1 && (live < 2 || live > 3))
                    board[i][j] = 2;              // live → dead
                else if (board[i][j] == 0 && live == 3)
                    board[i][j] = 3;              // dead → live
            }
        }
        // Second pass: collapse codes to final states
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] %= 2;                 // 2→0, 3→1
    }
    private int countLive(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                if (di == 0 && dj == 0) continue;
                int ni = i + di, nj = j + dj;
                if (ni >= 0 && ni < m && nj >= 0 && nj < n
                        && (board[ni][nj] == 1 || board[ni][nj] == 2))
                    count++;
            }
        }
        return count;
    }
}