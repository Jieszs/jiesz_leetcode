//给你一个字符串 s 和一个字符串列表 wordDict 作为字典，判定 s 是否可以由空格拆分为一个或多个在字典中出现的单词。 
//
// 说明：拆分时可以重复使用字典中的单词。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 
// 👍 1278 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean dfs(String s, int start, List<String> wordDict) {
        if (start == s.length()) {
            return true;
        }
        boolean ans = false;
        for (String word : wordDict) {
            if(start + word.length()>s.length()){
                continue;
            }
            if (word.equals(s.substring(start,start + word.length()))) {
                ans = ans || dfs(s, start + word.length(), wordDict);
            }

        }
        return ans;


    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, 0, wordDict);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
