//给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。 
//
// 
//
// 注意：本题与主站 445 题相同：https://leetcode-cn.com/problems/add-two-numbers-ii/ 
// Related Topics 栈 链表 数学 
// 👍 59 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode p = new ListNode();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int jinwei = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int a = s1.pop();
            int b = s2.pop();
            p.val = (a + b + jinwei) % 10;
            jinwei = (a + b + jinwei) / 10;
            ListNode q = new ListNode();
            q.next = p;
            p = q;
        }
        while (!s1.isEmpty() ) {
            int a = s1.pop();
            p.val = (a+ jinwei) % 10;
            jinwei = (a  + jinwei) / 10;
            ListNode q = new ListNode();
            q.next = p;
            p = q;
        }
        while (!s2.isEmpty()) {
            int b = s2.pop();
            p.val = (b + jinwei) % 10;
            jinwei = (b + jinwei) / 10;
            ListNode q = new ListNode();
            q.next = p;
            p = q;
        }
        if(jinwei!=0){
            p.val = jinwei;
            ListNode q = new ListNode();
            q.next = p;
            p = q;
        }
        return p.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
