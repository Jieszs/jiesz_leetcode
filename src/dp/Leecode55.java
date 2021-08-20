package dp;

/**
 * 55. 跳跃游戏
 * <p>
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
class Solution55 {

    public boolean jump(int[] nums) {
        int mx = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > mx) {
                return false;
            }
            mx = Math.max(mx, nums[i] + i);
        }
        return true;
    }
}

public class Leecode55 {
    public static void main(String[] args) {
        Solution55 solution = new Solution55();
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(solution.jump(nums));
    }

}
