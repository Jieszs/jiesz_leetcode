package dp;

/**
 * 918. 环形子数组的最大和
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 * <p>
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
 * <p>
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 * <p>
 * 输入：[3,-1,2,-1]
 * 输出：4
 * 解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
 */
class Solution918 {

    public int solute(int[] nums) {
        int total = nums[0];
        int min = nums[0];
        int max = nums[0];
        int maxPre = nums[0];
        int minPre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            total += nums[i];
            maxPre = Math.max(maxPre + nums[i], nums[i]);
            max = Math.max(max, maxPre);
            minPre = Math.min(minPre + nums[i], nums[i]);
            min = Math.min(min, minPre);
        }
        return total == min ? max : Math.max(max, total - min);
    }
}

public class Leecode918 {
    public static void main(String[] args) {
        Solution918 solution = new Solution918();
        int[] nums = {-3, -2, -1};
        System.out.println(solution.solute(nums));
    }

}
