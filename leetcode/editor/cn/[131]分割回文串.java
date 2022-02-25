//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 908 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    void dfs(char[] cs, int begin, List<String> pre, List<List<String>> result, int[][] dp) {
        int len = cs.length;
        if (begin >= len) {
            result.add(pre);
            return;
        }
        for (int i = begin; i < len; i++) {
            if (cs[i] == cs[begin] && (dp[begin][i] == 1 || check(cs, begin, i))) {
                dp[begin][i] = 1;
                List<String> t = new ArrayList<>(pre);
                t.add(new String(cs).substring(begin, i + 1));
                dfs(cs, i + 1, t, result, dp);
            }
        }
    }

    boolean check(char[] cs, int begin, int end) {
        while (begin <= end) {
            if (cs[begin] != cs[end]) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        char[] cs = s.toCharArray();
        int[][] dp = new int[cs.length][cs.length];
        List<String> pre = new ArrayList<>();
        dfs(cs, 0, pre, result, dp);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
