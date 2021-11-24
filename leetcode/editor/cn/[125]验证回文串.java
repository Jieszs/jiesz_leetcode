//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 105 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 429 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        char[] chars = s.toLowerCase().toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l <= r) {
            if (!isDigtalOrAlphebet(chars[l])) {
                l++;
                continue;
            }
            if (!isDigtalOrAlphebet(chars[r])) {
                r--;
                continue;
            }
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isDigtalOrAlphebet(char a) {
        if (a >= 'a' && a <= 'z' || a >= '0' && a <= '9') {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
