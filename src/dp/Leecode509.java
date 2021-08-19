package dp;

/**
 * 509. 斐波那契数
 */
class Solution509 {
    public int fib(int n) {
        int a = 0, b = 1;
        while (n-- > 0) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

}

public class Leecode509 {
    public static void main(String[] args) {
        Solution509 solution = new Solution509();

        System.out.println(solution.fib(10));
    }

}
