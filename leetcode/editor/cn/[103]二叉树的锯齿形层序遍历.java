//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 538 👎 0


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> q1 = new ArrayList<>();
        q1.add(root);
        int max = 0;
        while (q1.size() > 0) {
            List<TreeNode> q2 = new ArrayList<>();
            List<Integer> r1 = new ArrayList<>();
            max++;
            q2.addAll(q1);
            q1.clear();
            if (max % 2 == 0) {
                for (int i = q2.size()-1; i >=0; i--) {
                    TreeNode t =q2.get(i);
                    r1.add(t.val);
                }
            } else {
                for (TreeNode t : q2) {
                    r1.add(t.val);
                }
            }
            for (TreeNode t : q2) {
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
