//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 1068 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> q1 = new ArrayList<>();
        q1.add(root);
        while (q1.size() > 0) {
            List<TreeNode> q2 = new ArrayList<>();
            List<Integer> r1 = new ArrayList<>();
            q2.addAll(q1);
            q1.clear();
            for (TreeNode t : q2) {
                r1.add(t.val);
                if (t.left != null) {
                    q1.add(t.left);
                }
                if (t.right != null) {
                    q1.add(t.right);
                }
            }
            result.add(r1);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
