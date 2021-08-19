package dp;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都
 * 围成一圈
 * ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 */
class Solution213 {

    public int robRound(int[] value) {
        int len = value.length;
        int[] a = Arrays.copyOfRange(value, 0, len - 1);
        int[] b = Arrays.copyOfRange(value, 1, len);
        return Math.max(rob(a), rob(b));
    }

    private int rob(int[] value) {
        int len = value.length;
        int[] a = new int[len + 1];
        a[0] = 0;
        a[1] = value[0];
        for (int i = 2; i <= len; i++) {
            a[i] = Math.max(a[i - 1], a[i - 2] + value[i - 1]);
        }
        return a[len];
    }
}

public class Leecode213 {
    public static void main(String[] args) {
        Solution213 solution = new Solution213();
        int[] cost = {1, 2, 3, 1};
        System.out.println(solution.robRound(cost));
    }

}
