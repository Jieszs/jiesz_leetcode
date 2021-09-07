package dp;

/**
 * 152. 乘积最大子数组
 * <p>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 *
 * 解法
 * 考虑当前位置 i：
 *
 * 如果是一个负数的话，那么我们希望以它前一个位置结尾的某个段的积也是个负数，这样可以负负得正，并且我们希望这个积尽可能「负得更多」，即尽可能小。
 * 如果是一个正数的话，我们更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大。
 * 因此，分别维护 fmax 和 fmin。
 *
 * fmax(i) = max(nums[i], fmax(i - 1) * nums[i], fmin(i - 1) * nums[i])
 * fmin(i) = min(nums[i], fmax(i - 1) * nums[i], fmin(i - 1) * nums[i])
 * res = max(fmax(i)), i∈[0, n)
 */
class Solution152 {

    public int jump(int[] nums) {
        int result = nums[0];
        int minPre = 1;
        int maxPre = 1;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a == 0) {
                minPre = maxPre = 0;
            } else if (a > 0) {
                int maxPre1 = Math.max(maxPre * a, a);
                minPre = Math.min(minPre * a, 1);
                maxPre = maxPre1;

            } else {
                int maxPre1 = Math.max(minPre * a, a);
                minPre = Math.min(maxPre * a, a);
                maxPre = maxPre1;
            }
            result = Math.max(maxPre, result);
        }
        return result;
    }
}

public class Leecode152 {
    public static void main(String[] args) {
        Solution152 solution = new Solution152();
        int[] nums = {-4, -3, -2};
        System.out.println(solution.jump(nums));
    }

}
