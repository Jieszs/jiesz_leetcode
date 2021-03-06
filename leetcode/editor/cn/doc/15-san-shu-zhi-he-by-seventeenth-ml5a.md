## 要找出所有和为 0 且不重复的三元组。
暴力解法永远是最容易想到的,但是**不重复**应该怎么实现呢?
难道要用 Hash 表吗?那肯定是十分消耗时间的做法了.
### 思考不重复的表现和本质都是什么
(A,B,C),(A,C,B),(B,A,C),(B,C,A),(C,A,B),(C,B,A).里面的元素是不变的.
那么该如何**消除重复的三元组**?
答案是只需要**确定顺序**就可以了,如果我们**只计算(A,B,C)**这样的一种顺序,那么其他的**重复元组自然就被剔除了,也不会被考虑进去**.
****
### 前期准备工作
在本题目中我们调用`Arrays.sort(nums);`函数,进行递增排序
![D4A96235-CBF1-468D-A9B4-D1890536BFB1.png](https://pic.leetcode-cn.com/1634737424-XcJUbh-D4A96235-CBF1-468D-A9B4-D1890536BFB1.png)
## 如何找到 a + b + c =0 的组合呢?
> 根据**两数之和**的经验来看,**两数之和**是通过一个**固定**的数找另一个数.那么**三数之和**就是通过**一个固定的数**找另外两个数了.
那么毫无疑问,我们需要用到三个指针来帮助我们遍历数组.
![8A059037-2444-47AA-87BE-71629E259B6A.png](https://pic.leetcode-cn.com/1634737434-YXGaom-8A059037-2444-47AA-87BE-71629E259B6A.png)

 **fixed**指针**是三个指针中最小的指针****fixed<left<right**
1. 如果**fixed>0**,那么三数之和大于零,**fixed**无需向后遍历,因为数组单调递增,之后的三数之和也肯定大于零.直接结束运算.
2. 如果**fixed+left+right=0**,**left 和 right 指针同时向两侧移动**(如果只移动一个指针只能增加或者减少,不能寻找到下一个**三数之和为 0 位置组合**.
3. 如果**fixed+left+right<0**,那么**向右移动 left 指针**,使**三数之和增加**,希望可以找到**三数之和为 0 位置组合**.
4. 如果**fixed+left+right>0**,那么**向左移动 right 指针**,使**三数之和减少**,希望可以找到**三数之和为 0 位置组合**.
5. 如果**left<right**不成立,那么直接跳出,因为再进行下去也只是重复了之前已遍历过的数据,已经不满足**fixed<left<right**,会造成重复的.

# 代码实现
```java
public List<List<Integer>> threeSum(int[] nums) {
//        特殊判断
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
//            i是三个数中最小的数字,如果 i>0 了,那三数之和肯定大于零
            if (nums[i] > 0) break;
//            如果当前数字和上一个相等,那么直接跳过就好了
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left=i+1;
            int right=nums.length-1;

            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if (sum==0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
//                    进行判断
                    while (left<right&&nums[left]==nums[left+1]) left++;
                    while (left<right&&nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }else if (sum<0) left++;
                else right--;
            }

        }
            return result;


    }


```
代码参考https://leetcode-cn.com/u/guanpengchn/
略有改进




