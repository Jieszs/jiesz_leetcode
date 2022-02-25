//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 数组 数学 枚举 数论 
// 👍 793 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        int max = 5000005;
        int ans = 0;
        int[] prime = new int[max];
        for (int i = 2; i < n; i++) {
            int j = i;
            if ((long )(i * j) > n) break;

            while ((long )(i * j) < n) {
                prime[i * j] = 1;
                j++;
            }
        }
        for (int i = 2; i <n ; i++) {
            if (prime[i] == 0) {
                ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
