//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1642 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> first = new ArrayList<>();
            int[] v = new int[nums.length];
            first.add(nums[i]);
            v[i] = 1;
            dfs(nums, 1, result, first, v);
        }
        return result;
    }

    public void dfs(int[] nums, int deep, List<List<Integer>> result, List<Integer> pre, int[] v) {
        if (deep == nums.length) {
            result.add(pre);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (v[i] == 1) {
                continue;
            }
            List<Integer> first = new ArrayList<>(pre);
            v[i] = 1;
            first.add(nums[i]);
            dfs(nums, deep + 1, result, first, v);
            v[i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
