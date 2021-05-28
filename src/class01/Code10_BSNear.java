package class01;

import java.util.Arrays;

/**
 * 在有序数组中，找到 >= num 最左侧的位置
 * 在有序数组中，找到 <= num 最右侧的位置
 *
 * @author YKrystal
 * @date 2021/5/28
 */
public class Code10_BSNear {
    public static int nearestLeft(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        // 记录临时结果
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= num) {
                // mid这个数确实符合要求，记录下来，但不能保证是最左的，还要向左看
                index = mid;
                right = mid - 1;
            } else {
                // arr[mid] < num
                left = mid + 1;
            }
        }

        return index;
    }

    public static int correctNearestLeft(int[] arr, int num) {
        if (arr == null || arr.length == 0)
            return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num)
                return i;
        }
        return -1;
    }

    public static int nearestRight(int[] arr, int num) {
        if (arr == null || arr.length == 0)
            return -1;

        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= num) {
                // 不能确定就是最右边的一个小于num的值，继续向右看
                index = mid;
                left = mid + 1;
            } else {
                // arr[mid] > num
                right = mid - 1;
            }
        }

        return index;
    }

    public static int correctNearestRight(int[] arr, int num) {
        if (arr == null || arr.length == 0)
            return -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= num)
                return i;
        }
        return -1;
    }

    public static int[] getRandomArray(int maxLength, int maxValue) {
        int[] ans = new int[(int) (Math.random() * maxLength)];
        for (int i = 0; i < ans.length; i++)
            ans[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);

        return ans;
    }

    public static void main(String[] args) {
        int testTime = 10000;
        int maxLength = 150;
        int maxValue = 100;
        int random = 0;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = getRandomArray(maxLength, maxValue);
            random = (int) (Math.random() * maxValue);
            Arrays.sort(arr);

            int ans1 = nearestLeft(arr, random);
            int ans2 = correctNearestLeft(arr, random);

            int ans3 = nearestRight(arr, random);
            int ans4 = correctNearestRight(arr, random);

            if (ans1 != ans2) {
                System.out.println("shit");
                System.out.println(Arrays.toString(arr));
                System.out.println("ans1 = " + ans1);
                System.out.println("ans2 = " + ans2);
                break;
            }

            if (ans3 != ans4) {
                System.out.println("shit");
                System.out.println(Arrays.toString(arr));
                System.out.println("ans3 = " + ans3);
                System.out.println("ans4 = " + ans4);
                break;
            }
        }
        System.out.println("test finish");
    }
}
