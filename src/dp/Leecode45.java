package dp;

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
 * [1,2]
 * 1
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 *
 * 思路：
 * 遍历数组，计算每一步能走的最大范围，超过这一步的最大范围，就增加步数
 */
class Solution45 {

    public int jump(int[] nums) {
        int len = nums.length;
        int max = 0;
        int newMax = 0;
        int times = 0;
        for (int i = 0; i < len - 1; i++) {
            newMax = Math.max(newMax, nums[i] + i);
            if (i == max) {
                times++;
                max = newMax;
            }
        }
        return times;
    }
}

public class Leecode45 {
    public static void main(String[] args) {
        Solution45 solution = new Solution45();
        int[] nums = {1};
        System.out.println(solution.jump(nums));
    }

}
