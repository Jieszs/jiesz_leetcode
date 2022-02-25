//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 贪心 字符串 排序 
// 👍 833 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = "" + nums[i];
        }
        Arrays.sort(strs, (o1, o2) -> {
            char[] c1 = o1.toCharArray();
            char[] c2 = o2.toCharArray();
            int i;
            for (i = 0; i < c1.length + c2.length; i++) {
                if ((c1[i % c1.length] - c2[i % c2.length]) < 0) {
                    return 1;
                }
                if ((c1[i % c1.length] - c2[i % c2.length]) > 0) {
                    return -1;
                }

            }
            return 0;

        });
        StringBuilder sb = new StringBuilder();
        for (String s : strs
        ) {
            sb.append(s);

        }

        return sb.toString().startsWith("0")?"0":sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
