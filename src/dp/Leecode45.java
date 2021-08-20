package dp;

import java.util.Arrays;

/**
 * 45. 跳跃游戏(二)
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
class Solution45 {

    public int jump(int[] nums) {
        int end = 0;
        int mx = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            mx = Math.max(mx, i + nums[i]);
            if (i == end) {
                end = mx;
                ++steps;
            }
        }
        return steps;
    }
}

public class Leecode45 {
    public static void main(String[] args) {
        Solution45 solution = new Solution45();
        int[] nums = {2,3,1,1,4};
        System.out.println(solution.jump(nums));
    }

}
