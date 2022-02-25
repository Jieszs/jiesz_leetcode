//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 
// 👍 1089 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int[][] v = new int[board.length][board[0].length];

                if (board[i][j] == w[0]) {
                    if (dfs(i, j, board, w, 0, v)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    boolean dfs(int i, int j, char[][] board, char[] w, int d, int[][] v) {
        v[i][j] = 1;
        int m = board.length - 1;
        int n = board[0].length - 1;
        if (d == w.length - 1) {
            return true;
        }
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean e = false;
        if (i - 1 >= 0 && v[i - 1][j] == 0 && board[i - 1][j] == w[d + 1]) {
            a = dfs(i - 1, j, board, w, d + 1, v);
        }
        if (j - 1 >= 0 && v[i][j - 1] == 0 && board[i][j - 1] == w[d + 1]) {
            b = dfs(i, j - 1, board, w, d + 1, v);
        }
        if (j < n && v[i][j + 1] == 0 && board[i][j + 1] == w[d + 1]) {
            c = dfs(i, j + 1, board, w, d + 1, v);
        }
        if (i < m && v[i + 1][j] == 0 && board[i + 1][j] == w[d + 1]) {
            e = dfs(i + 1, j, board, w, d + 1, v);
        }
        v[i][j] = 0;
        return a || b || c || e;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
