//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 2138 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    void dfs(int l, int n, String s, List<String> result) {
        if (l == 0 && n == 0) {
            result.add(s);
            return;
        }
        if (l - 1 >= 0) {
            dfs(l - 1, n, s + "(", result);
        }
        if (n - 1 >= 0 && n - 1 >= l) {
            dfs(l, n - 1, s + ")", result);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n > 0) {
            dfs(n - 1, n, "(", result);
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
