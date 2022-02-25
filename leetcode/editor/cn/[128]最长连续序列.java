//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 哈希表 
// 👍 984 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            map.put(num, 1);
            int l = num;
            int r = num;
            int length = 1;

            if (map.containsKey(num - 1)) {
                l = num - map.get(num - 1);
                length += map.get(l);
            }
            if (map.containsKey(num + 1)) {
                r = num + map.get(num + 1);
                length += map.get(num + 1);
            }
            map.put(l, length);
            map.put(r, length);
            max = Math.max(max, length);
        }

        return max;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
