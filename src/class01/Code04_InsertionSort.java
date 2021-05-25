package class01;

import java.util.Arrays;

/**
 * 插入排序
 * 1.让0 ~ 0 做到有序，ok
 * 2.让0 ~ 1 做到有序，从1开始，不断和前一个比较，小就往前移动
 * 3.让0 ~ 2 做到有序，从2开始，不断和前一个比较，小就往前移动
 * 4..重复
 * 5.让0 ~ n-1，需要看到最后一个位置
 * <p>
 * [3,4,3,5,1]
 *
 * @author YKrystal
 */
public class Code04_InsertionSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 从1开始，看到最后一个
        for (int i = 1; i < arr.length; i++) {
            // 从前一个开始比，不断向前比
            for (int j = i - 1; j > 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 3, 21, 8, 7, 43, 34, 71, 92, 72, 12, 65, 9};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
