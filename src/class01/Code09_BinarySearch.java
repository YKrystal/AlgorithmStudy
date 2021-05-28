package class01;

import java.util.Arrays;

/**
 * 二分搜索，要求是有序数组
 *
 * @author YKrystal
 * @date 2021/5/28
 */
public class Code09_BinarySearch {
    public static boolean search(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    // 编写绝对正确的方法，用于验证
    public static boolean correct(int[] arr, int num) {
        if (arr == null || arr.length == 0)
            return false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                return true;
        }

        return false;
    }

    // 利用Math.random()，产生随机数组，用于测试
    public static int[] getRandomArray(int maxLength, int maxValue) {
        int[] ans = new int[((int) (Math.random() * maxLength))];
        for (int i = 0; i < ans.length; i++)
            ans[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);

        return ans;
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxLength = 150;
        int maxValue = 500;
        // 随机要找的数据
        int random = 0;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = getRandomArray(maxLength, maxValue);
            // 做成有序的
            Arrays.sort(arr);

            random = (int) (Math.random() * maxValue);

            // 自己编写的方法
            boolean res1 = search(arr, random);
            // 绝对正确的方法
            boolean res2 = correct(arr, random);

            if (res1 != res2) {
                System.out.println("shit");
                System.out.println(Arrays.toString(arr));
                System.out.println("res1 = " + res1);
                System.out.println("res2 = " + res2);
                break;
            }
        }
        System.out.println("test finish");
    }
}
