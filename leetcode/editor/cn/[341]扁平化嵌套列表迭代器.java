//给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。请你实现一个迭代器将其扁平化
//，使之能够遍历这个列表中的所有整数。 
//
// 实现扁平迭代器类 NestedIterator ： 
//
// 
// NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。 
// int next() 返回嵌套列表的下一个整数。 
// boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。 
// 
//
// 你的代码将会用下述伪代码检测： 
//
// 
//initialize iterator with nestedList
//res = []
//while iterator.hasNext()
//    append iterator.next() to the end of res
//return res 
//
// 如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。 
//
// 
//
// 示例 1： 
//
// 
//输入：nestedList = [[1,1],2,[1,1]]
//输出：[1,1,2,1,1]
//解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
//
// 示例 2： 
//
// 
//输入：nestedList = [1,[4,[6]]]
//输出：[1,4,6]
//解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nestedList.length <= 500 
// 嵌套列表中的整数值在范围 [-106, 106] 内 
// 
// Related Topics 栈 树 深度优先搜索 设计 队列 迭代器 
// 👍 391 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> nestedList;
    int index = 0;
    List<Integer> listIndexs = new ArrayList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        NestedInteger i = nestedList.get(index);
        if (i.isInteger()) {
            index++;
            return i.getInteger();
        }
        List<NestedInteger> list = i.getList();
        if (listIndexs.size == 0) {
            listIndexs.add(0);
        }
        boolean find = false;
        for (int j = 0; j < listIndexs.size(); j++) {
            int tmpIndex = listIndexs.get(j);
            NestedInteger tmp = list.get(tmpIndex);
            if (tmp.isInteger()) {
                tmpIndex++;
                listIndexs.remove(j);
                if (list.size() > tmpIndex) {
                    listIndexs.add(tmpIndex);
                } else {
                    while (j-1>=0){
                        if (j - 1 == 0) {
                            index++;
                        }else {
                            int preIndex = listIndexs.get(j-1);
                            listIndexs.remove(j-1);

                        }
                    }


                }
                return tmp;
            }
            list = tmp.getList();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return nestedList.get(index) != null;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)
