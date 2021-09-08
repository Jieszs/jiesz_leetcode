package dp;

/**
 * 1567. 乘积为正数的最长子数组长度
 * <p>
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 * <p>
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * <p>
 * 请你返回乘积为正数的最长子数组长度
 * <p>
 * 输入：nums = [0,1,-2,-3,-4]
 * 输出：3
 * 输入：nums = [1,2,3,5,-6,4,0,10]
 * 输出：4
 * <p>
 * 思路：
 * 分情况考虑，0，大于0，小于0
 * z表示最长正数长度，f表示最长负数长度
 * 大于0， z=z+1 ,如果之前有负数 f=f+1,否则f还是0
 * 小于0， 如果之前有负数 z=f+1,f=z+1否则f=f+1,z=0
 * 0 ，z=f=0
 */
class Solution1567 {

    public int jump(int[] nums) {
        int res = 0;
        int z = 0;
        int f = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a == 0) {
                z = 0;
                f = 0;
            } else if (a > 0) {
                z++;
                if (f > 0) {
                    f++;
                }
            } else {
                if (f > 0) {
                    f++;
                    int t = z + 1;
                    z = f;
                    f = t;
                } else {
                    f = z + 1;
                    z = 0;
                }
            }
            res = Math.max(z, res);
        }
        return res;
    }
}

public class Leecode1567 {
    public static void main(String[] args) {
        Solution1567 solution = new Solution1567();
        int[] nums = {-7, -10, -7, 21, 20, -12, -34, 26, 2};
        System.out.println(solution.jump(nums));
    }

}
