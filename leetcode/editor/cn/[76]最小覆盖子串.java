//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 1539 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[60];
        Arrays.fill(map, -99999);
        char[] cs = t.toCharArray();
        for (char c : cs) {
            if (map[c - 'A'] < 0) {
                map[c - 'A'] = 1;
                continue;
            }
            map[c - 'A']++;
        }
        char[] cs2 = s.toCharArray();
        int sum = cs.length;
        //先找start 位置
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minEnd = cs2.length;

        for (; start < cs2.length; start++) {
            if (map[cs2[start] - 'A'] > 0) {
                map[cs2[start] - 'A']--;
                sum--;
                break;

            }
        }
        //没找到
        if (start == cs2.length) return "";
        //找end
        for (int i = start + 1; i < cs2.length; i++) {
            //没命中
            if (map[cs2[i] - 'A'] == -99999) {
                continue;
            }
            //命中map，且有剩余
            if (map[cs2[i] - 'A'] > 0) {
                map[cs2[i] - 'A']--;
                sum--;
                //全部存在，替换最小的start 和 end
                if (sum == 0) {
                    int end = i;
                    if (end - start < minEnd - minStart) {
                        minEnd = end;
                        minStart = start;
                    }
                }
                continue;
            }
            //命中map，且没有剩余，尝试移动start
            if (map[cs2[i] - 'A'] <= 0) {
                map[cs2[i] - 'A']--;
                //全部存在，替换最小的start 和 end
                if (sum == 0) {
                    int end = i;
                    if (end - start < minEnd - minStart) {
                        minEnd = end;
                        minStart = start;
                    }
                }
                continue;
            }

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
