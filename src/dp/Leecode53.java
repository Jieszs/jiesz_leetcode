package dp;

/**
 * 53. 最大子序和
 * 题目描述
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * <p>
 * 思路：
 * dp[i]=(dp[i-1]+dp[i],dp[i])
 */
class Solution53 {

    public int jump(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}

public class Leecode53 {
    public static void main(String[] args) {
        Solution53 solution = new Solution53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.jump(nums));
    }

}
