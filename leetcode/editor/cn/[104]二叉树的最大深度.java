//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1012 👎 0


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
    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) return max;
        List<TreeNode> q1 = new ArrayList<>();
        q1.add(root);
        while (q1.size() > 0) {
            max++;
            List<TreeNode> q2 = new ArrayList<>();
            q2.addAll(q1);
            q1.clear();
            for (TreeNode t : q2) {
                if (t.left != null) {
                    q1.add(t.left);
                }
                if (t.right != null) {
                    q1.add(t.right);
                }
            }
        }

        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
