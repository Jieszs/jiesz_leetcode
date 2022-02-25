//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 
// 👍 1082 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        //指向下一个0的位置
        int l = 0;
        //指向上一个2的位置
        int r = nums.length - 1;
        //当两端都有序时，结束
        for (int i = 0; i <= r; ) {
            //如果是0，和l位置交换，如果i=l，即自己与自己交换，则i++
            if (nums[i] == 0) {
                int t = nums[l];
                nums[l] = nums[i];
                nums[i] = t;
                l++;
                if (i < l) {
                    i++;
                }
                continue;
            }
            //如果是2，和r位置交换
            if (nums[i] == 2) {
                int t = nums[r];
                nums[r] = nums[i];
                nums[i] = t;
                r--;
                continue;
            }
            //如果是1，移动
            i++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
