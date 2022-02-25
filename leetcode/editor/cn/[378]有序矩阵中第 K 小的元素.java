//给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//输出：13
//解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[-5]], k = 1
//输出：-5
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length 
// n == matrix[i].length 
// 1 <= n <= 300 
// -109 <= matrix[i][j] <= 109 
// 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列 
// 1 <= k <= n2 
// 
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列） 
// 👍 716 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Node {
        int x;
        int y;
        int v;

        Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> q = new PriorityQueue<>(2 * k, (o1, o2) -> o1.v - o2.v);
        int n = matrix[0].length;
        int[][] v = new int[n][n];

        q.offer(new Node(0, 0, matrix[0][0]));
        while (!q.isEmpty()) {
            Node t = q.poll();
            k--;
            if (0 == k) {
                return t.v;
            }
            if (t.x + 1 < n && v[t.x + 1][t.y] ==0){
                v[t.x + 1][t.y] = 1;
                q.offer(new Node(t.x + 1, t.y, matrix[t.x + 1][t.y]));
            }
            if (t.y + 1 < n && v[t.x][t.y + 1] == 0) {
                v[t.x][t.y + 1] = 1;
                q.offer(new Node(t.x, t.y + 1, matrix[t.x][t.y + 1]));
            }
        }
        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
