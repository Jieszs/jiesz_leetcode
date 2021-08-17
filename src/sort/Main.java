package sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] nums = {32, 83, 74, 12, 16, 35, 46, 36, 23, 41, 75, 1, 99, 45, 63, 11};
        radixSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }

    }

    /**
     * 选择排序
     *
     * @param nums
     */
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(nums, minIndex, i);

            }
        }
    }

    /**
     * 插入排序
     *
     * @param nums
     */
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int tmp = nums[j];
            for (; j > 0 && tmp < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }
            if (j != i) {
                nums[j] = tmp;
            }
        }
    }


    public static int[] mergerSort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        if (arr.length < 2) {
            return arr;
        }
        int len = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, len);
        int[] right = Arrays.copyOfRange(nums, len, nums.length);
        return merge(mergerSort(left), mergerSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] > right[0]) {
                result[i] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            } else {
                result[i] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            }
            i++;
        }
        for (int j = 0; j < left.length; j++) {
            result[i++] = left[j];
        }
        for (int j = 0; j < right.length; j++) {
            result[i++] = right[j];
        }
        return result;
    }

    public static void shellsSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    swap(arr, j + gap, j);
                    j -= gap;
                }
            }

            gap = gap / 2;
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (right - left < 2) {
            return;
        }
        int index = left + 1;
        int tmp = arr[left];
        for (int i = left + 1; i < right; i++) {
            if (tmp > arr[i]) {
                arr[index - 1] = arr[i];
                arr[i] = arr[index];
                index++;
            }
        }

        arr[index - 1] = tmp;
        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    public static void heapSort(int[] nums) {
        //拼凑最大堆
        for (int i = 0; i < nums.length; i++) {
            buildMaxHeap(nums, i);
        }
        //取出最大，重新构建最大堆
        for (int i = nums.length - 1; i > 0; i--) {
            heapify(nums, i);
        }
    }

    private static void heapify(int[] nums, int len) {
        swap(nums, 0, len);
        shift(nums, 0, len - 1);
    }

    private static void shift(int[] nums, int i, int len) {
        int l = i * 2 + 1;
        int r = l + 1;
        //没有左节点，返回
        if (l > len) {
            return;
        }
        //左右节点都有，选最大的，之后在shift一次
        if (r <= len) {
            int max = i;
            if (nums[max] < nums[l]) {
                max = l;
            }
            if (nums[max] < nums[r]) {
                max = r;
            }
            if (max == i) {
                return;
            }
            swap(nums, i, max);
            shift(nums, max, len);
            return;
        }
        //最后的左节点
        if (nums[l] > nums[i]) {
            swap(nums, l, i);
        }

    }

    public static void radixSort(int[] nums) {
        int max = getMaxVal(nums);
        int digital = getDigital(max);
        int[][] arr = new int[10][0];
        for (int j = 0; j < nums.length; j++) {
            int a = getCurrentNum(nums[j], 1);
            arr[a] = appendBuck(arr[a], nums[j]);
        }
        for (int i = 2; i <= digital; i++) {
            int[][] brr = new int[10][0];
            for (int j = 0; j < 10; j++) {
                int[] crr = arr[j];
                for (int k = 0; k < crr.length; k++) {
                    int a = getCurrentNum(crr[k], digital);
                    brr[a] = appendBuck(brr[a], crr[k]);
                }
            }
            arr = brr;
        }
        int i = 0;
        for (int j = 0; j < 10; j++) {
            int[] crr = arr[j];
            for (int k = 0; k < crr.length; k++) {
                nums[i++] = crr[k];
            }
        }
    }

    public static void buckSort(int[] nums, int buckSize) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int hash = (max - min) / buckSize + 1;
        int[][] buck = new int[buckSize][1];
        for (int i = 0; i < nums.length; i++) {
            //可能出现，value =0 的情况，buck[][0],统一不用
            buck[(nums[i] - min) / hash] = appendBuckAndSort(buck[(nums[i] - min) / hash], nums[i]);
        }
        int k = 0;
        for (int i = 0; i < buckSize; i++) {
            int[] arr = buck[i];
            for (int j = 1; j < arr.length; j++) {
                nums[k++] = arr[j];
            }
        }
    }

    private static int[] appendBuckAndSort(int[] arr, int num) {
        arr = Arrays.copyOfRange(arr, 0, arr.length + 1);
        arr[arr.length - 1] = num;
        for (int i = arr.length - 2; i > 0; i--) {
            if (arr[i] > num) {
                swap(arr, i, i + 1);
            }
        }
        return arr;
    }

    private static int[] appendBuck(int[] arr, int num) {
        arr = Arrays.copyOfRange(arr, 0, arr.length + 1);
        arr[arr.length - 1] = num;
        return arr;
    }

    private static void buildMaxHeap(int[] nums, int len) {
        int parent = (len + 1) / 2;
        if (parent < 1) {
            return;
        }
        if (nums[parent - 1] < nums[len]) {
            swap(nums, parent - 1, len);
            buildMaxHeap(nums, parent - 1);
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static int getMaxVal(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    private static int getDigital(int num) {
        int i = 0;
        while (num > 0) {
            num /= 10;
            i++;
        }
        return i;
    }

    private static int getCurrentNum(int num, int index) {
        int div = 1;
        while (index - 1 > 0) {
            div *= 10;
            index--;
        }
        return (num / div) % 10;
    }
}
