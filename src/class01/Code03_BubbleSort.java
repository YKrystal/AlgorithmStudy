package class01;

import java.util.Arrays;

/**
 * 冒泡排序
 * 一：在0 ~ n-1之间，从0开始，两两比较，大的往后移动
 * 二：在0 ~ n-2之间，从0开始，两两比较，大的往后移动
 * ...
 * n-1 ：在0 ~ 1 之间，比较
 * 0 和 0 之间不做了
 */
public class Code03_BubbleSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            // 从0开始，两两比较
            for (int pre = 0; pre < end; pre++) {
                // 索引小的数值大，往后移动
                if (arr[pre] > arr[pre + 1]) {
                    swap(arr, pre, pre + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 3, 21, 8, 7, 43, 34, 71, 92, 72, 12, 65, 9};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
