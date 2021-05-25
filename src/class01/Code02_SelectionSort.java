package class01;

import java.util.Arrays;

/**
 * 选择排序
 * 先从 0 ~ n-1 找一个最小值，和0位置交换
 * 再从 1 ~ n-1 找一个最小值，和1位置交换
 * ...
 * n-2 和 n-1取最小值，和n-2交换
 * 不用遍历到n-1和n-1比较
 *
 * @author YKrystal
 */
public class Code02_SelectionSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            // 先假定它是最小值，再往后比较
            int minIndex = i;
            // 确定最小值的位置
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            // 最小值位置和当前位置交换
            swap(arr, i, minIndex);

        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 3, 21, 8, 7, 43, 34, 71, 92, 72, 12, 65, 9};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
