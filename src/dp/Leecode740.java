package dp;

/**
 * 740. 删除与获得点数 * <p>
 * 给定一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * 输入: nums = [2, 2, 3, 3, 3, 4]
 * 输出: 9
 */
class Solution740 {

    public int deleteAndGet(int[] nums) {
        int a[] = new int[10010];
        int b[] = new int[10010];
        for (int i = 0; i < nums.length; i++) {
            a[nums[i]]++;
        }
        b[0] = a[0];
        b[1] = a[1];
        for (int i = 2; i < a.length; i++) {
            b[i] = Math.max(b[i - 1], b[i - 2] + a[i] * i);
        }
        return b[a.length - 1];
    }


}

public class Leecode740 {
    public static void main(String[] args) {
        Solution740 solution = new Solution740();
        int[] cost = {2, 2, 3, 3, 3, 4};
        System.out.println(solution.deleteAndGet(cost));
    }

}
