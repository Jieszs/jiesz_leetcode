package dp;

/**
 * 1137. 第 N 个泰波那契数
 */
class Solution1137 {
    public int tribonacci(int n) {
        int a = 0, b = 1, c = 1;
        while (n-- > 0) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return a;
    }
}

public class Leecode1137 {


    public static void main(String[] args) {
        Solution1137 solution = new Solution1137();

        System.out.println(solution.tribonacci(10));
    }
}
