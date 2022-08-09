//给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=105 
// 0 <= heights[i] <= 104 
// 
//
// 
//
// 注意：本题与主站 84 题相同： https://leetcode-cn.com/problems/largest-rectangle-in-histog
//ram/ 
// Related Topics 栈 数组 单调栈 
// 👍 52 👎 0


/**
 * 思路：
 * 遍历数字,找在当前位置之前，不小于当前数值大的最远长度，和在当前位置之后，不小于当前数值大的最远长度。
 * 当前位置的最大值为 pre * (after[prei] - before[prei] + 1)
 * 所以重点在，如何快速的找这个位置
 * 使用单调栈，如果当前元素大于等于栈内元素，那么当前元素就可以入栈，栈内所有元素的after[i]都是当前元素所在位置
 * 而当前元素的before[i]是自己
 * 如果，小于栈顶元素，那么当前元素的before[i]就是栈顶元素，计算栈顶元素的最大面积
 * 之后，一直出栈判断，知道栈为空，或者栈顶元素大于当前元素
 * 值得注意的是，栈内元素的after，我采用的是惰性更新
 *
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int largestRectangleArea(int[] heights) {
        //存储在当前位置之前，不小于当前数值大的最远长度
        int[] before = new int[heights.length];
        //存储在当前位置之后，不小于当前数值大的最远长度
        int[] after = new int[heights.length];
        //单调栈
        Stack<Integer> s = new Stack<>();
        int max = 0;
        //初始化，为自己
        for (int i = 0; i < before.length; i++) {
            before[i] = i;
            after[i] = i;
        }
        for (int i = 0; i < heights.length; i++) {

            if (s.isEmpty()) {
                s.push(i);
                continue;
            }
            int t = -1;
            while (!s.isEmpty()) {
                int cur = heights[i];
                int prei = s.pop();
                int pre = heights[prei];
                if (t != -1) {
                    after[prei] = t;
                    t = -1;
                }
                if (pre <= cur) {
                    s.push(prei);

                    after[prei] = i;
                    break;
                }
                max = Math.max(max, pre * (after[prei] - before[prei] + 1));
                before[i] = before[prei];
                t = after[prei];
            }
            s.push(i);

        }
        int t = -1;
        while (!s.isEmpty()) {
            int prei = s.pop();
            if (t == -1) {
                t = after[prei];
            }
            int pre = heights[prei];
            max = Math.max(max, pre * (t- before[prei] + 1));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
