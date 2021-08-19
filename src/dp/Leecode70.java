package dp;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *想上第 n 级台阶，可从第 n-1 级台阶爬一级上去，也可从第 n-2 级台阶爬两级上去，
 * 即：f(n) = f(n-1) + f(n-2)。递推求解即可。
 *
 *
 */
class Solution70 {

    public int climbStairs(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; ++i) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}

public class Leecode70 {
    public static void main(String[] args) {
        Solution70 solution = new Solution70();

        System.out.println(solution.climbStairs(3));
    }

}
