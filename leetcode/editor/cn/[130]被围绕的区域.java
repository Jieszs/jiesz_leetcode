//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X"
//,"X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 671 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    void dfs(int j, int i, int[][] v, char[][] board) {
        int n = board.length;
        int m = board[0].length;
        v[i][j] = 1;
        if (i + 1 < n && v[i + 1][j] == 0 && board[i + 1][j] == 'O') {
            dfs(j, i + 1, v, board);
        }
        if (i - 1 >= 0 && v[i - 1][j] == 0 && board[i - 1][j] == 'O') {
            dfs(j, i - 1, v, board);
        }
        if (j + 1 < m && v[i][j + 1] == 0 && board[i][j + 1] == 'O') {
            dfs(j + 1, i, v, board);
        }
        if (j - 1 >= 0 && v[i][j - 1] == 0 && board[i][j - 1] == 'O') {
            dfs(j - 1, i, v, board);
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        if (m <= 2 || n <= 2) {
            return;
        }
        int[][] v = new int[n][m];
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                dfs(i, 0, v, board);
            }
            if (board[n - 1][i] == 'O') {
                dfs(i, n - 1, v, board);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(0, i, v, board);
            }
            if (board[i][m - 1] == 'O') {
                dfs(m - 1, i, v, board);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (v[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
