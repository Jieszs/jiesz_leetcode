package dp;

/**
 * 746. 最小代价爬楼梯
 * <p>
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯
 * <p>
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 */
class Solution746 {

    public int climbStairs(int[] cost) {
        int len = cost.length;
        int[] a = new int[len + 1];
        for (int i = 2; i <= len; i++) {
            a[i] = Math.min(a[i - 1] + cost[i - 1], a[i - 2] + cost[i - 2]);
        }
        return a[len];
    }
}

public class Leecode746 {
    public static void main(String[] args) {
        Solution746 solution = new Solution746();
        int[] cost = {10, 15, 20};
        System.out.println(solution.climbStairs(cost));
    }

}
