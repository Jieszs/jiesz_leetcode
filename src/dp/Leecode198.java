package dp;

/**
 * 198. 打家劫舍
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 */
class Solution198 {

    public int rob(int[] value) {
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

public class Leecode198 {
    public static void main(String[] args) {
        Solution198 solution = new Solution198();
        int[] cost = {2,7,9,3,1};
        System.out.println(solution.rob(cost));
    }

}
