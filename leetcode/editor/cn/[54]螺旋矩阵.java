//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 914 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] visits = new int[n][m];
        int direction = 0;
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while (true) {
            if (i >= m || j >= n || i < 0 || j < 0|| visits[j][i] == 1 ) {
                break;
            }
            result.add(matrix[j][i]);
            visits[j][i] = 1;
            switch (direction) {
                case 0:
                    i++;
                    if (i >= m || visits[j][i] == 1) {
                        i--;
                        direction++;
                        j++;
                    }
                    break;
                case 1:
                    j++;
                    if (j >= n || visits[j][i] == 1) {
                        j--;
                        direction++;
                        i--;
                    }
                    break;
                case 2:
                    i--;
                    if (i < 0 || visits[j][i] == 1) {
                        i++;
                        direction++;
                        j--;
                    }
                    break;
                case 3:
                    j--;
                    if (j < 0 || visits[j][i] == 1) {
                        j++;
                        direction = 0;
                        i++;
                    }
                    break;
                default:
                    break;

            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
