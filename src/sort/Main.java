package sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] nums = {83, 74, 12, 16, 35, 46, 36, 23, 41, 75};
        shellsSort(nums);
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

    public static void shellsSort(int[] nums) {
        int gap = nums.length / 2;
        while (gap > 1) {
            for (int i = 0; i < gap; i++) {
                for (int j = i; j < nums.length; j = j + gap) {
                    int k = j;
                    int tmp = nums[j + gap];
                    for (; k > i && nums[k] > tmp; k = k - gap) {
                        nums[k + gap] = nums[k];
                    }
                    if (k != j) {
                        nums[k] = tmp;
                    }
                }
            }
            gap = gap / 2;
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
