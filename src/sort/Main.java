package sort;

import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {
        int[] nums = {83, 74, 12, 16, 35, 46, 36, 23, 41, 75};
        bubbleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void mergerSort(int[] nums) {
        merge(nums, 0, nums.length);
    }

    private static void merge(int[] nums, int left, int right) {
        int len = (right - left) / 2;
        if (len > 1) {
            merge(nums, left, len);
            merge(nums, len + 1, right);
        }
        merge2(nums, left, len, right);
    }

    private static void merge2(int[] nums, int left, int len, int right) {
        int l = left;
        int r = len + 1;
        for (int i = l; i < len; i++) {
            for (int j = r; j < right; j++) {
                if (nums[i] < nums[j]) {
                    l++;
                    break;
                }

            }
        }
    }
}
