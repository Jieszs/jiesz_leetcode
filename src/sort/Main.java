package sort;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] nums = {83, 74, 12, 16, 35, 46, 36, 23, 41, 75};
        insertSort(nums);
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

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
