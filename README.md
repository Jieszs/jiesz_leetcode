# 刷题记录

学习地址：
https://github.com/doocs/leetcode  刷题顺序-不懂看图解算法

https://github.com/MisterBooo/LeetCodeAnimation 图解算法

https://github.com/geekxh/hello-algorithm 查缺补漏   

## 算法模板
归并排序
```
void mergeSort(int[] nums, int left, int right) {
    if (left >= right) {
        return;
    }
    int mid = (left + right) >>> 1;
    mergeSort(nums, left, mid);
    mergeSort(nums, mid + 1, right);
    int i = left, j = mid + 1, k = 0;
    while (i <= mid && j <= right) {
        if (nums[i] <= nums[j]) {
            tmp[k++] = nums[i++];
        } else {
            tmp[k++] = nums[j++];
        }
    }
    while (i <= mid) {
        tmp[k++] = nums[i++];
    }
    while (j <= right) {
        tmp[k++] = nums[j++];
    }
    for (i = left, j = 0; i <= right; ++i, ++j) {
        nums[i] = tmp[j];
    }
}
```
快速排序
```
void quickSort(int[] nums, int left, int right) {
    if (left >= right) {
        return;
    }
    int i = left - 1, j = right + 1;
    int x = nums[left];
    while (i < j) {
        while (nums[++i] < x);
        while (nums[--j] > x);
        if (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
    quickSort(nums, left, j);
    quickSort(nums, j + 1, right);
}
```

二分查找
```
/** 检查x是否满足某种性质 */
boolean check(int x) {}

/** 区间[left, right]被划分成[left, mid]和[mid + 1, right]时使用 */
int binarySearch1(int left, int right) {
    while (left < right) {
        int mid = (left + right) >> 1;
        if (check(mid)) right = mid;
        else left = mid + 1;
    }
    return left;
}

/** 区间[left, right] 被划分成[left, mid - 1]和[mid, right]时使用 */
int binarySearch2(int left, int right) {
    while (left < right) {
        int mid = (left + right + 1) >> 1;
        if (check(mid)) left = mid;
        else right = mid - 1;
    }
    return left;
}
```