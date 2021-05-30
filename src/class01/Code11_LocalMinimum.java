package class01;

import java.util.Arrays;

/**
 * 局部最小值，返回任意一个局部最小值
 * arr[0] < arr[1], 0位置称为局部最小
 * arr[n-1] < arr[n-2], n-1位置称为局部最小
 * arr[x-1] < arr[x] < arr[x+1], x称为局部最小
 * 给定的数组，相邻两个数不同
 *
 * @author YKrystal
 * @date 2021/5/30
 */
public class Code11_LocalMinimum {
    public static int localMinimum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // arr中就一个数，认为这个位置是局部最小
        if (arr.length == 1) {
            return 0;
        }
        // 至少两个数
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        // 此时的arr，先下降，再上升的趋势，中间必有一个最小值
        // 开始找
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                // 中间的数 大于 左边的，呈上升趋势，先下降，在上升，往左划
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                // 呈现下降趋势，往右划
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }


    public static boolean correctLocalMinimum(int[] arr, int answerIndex) {
        if (arr == null || arr.length == 0) {
            return answerIndex == -1;
        }

        if (arr.length == 1) {
            return answerIndex == 0;
        }

        // 至少有两个数
        boolean left = answerIndex - 1 >= 0 ? arr[answerIndex] < arr[answerIndex - 1] : true;

        boolean right = answerIndex + 1 <= arr.length - 1 ? arr[answerIndex] < arr[answerIndex + 1] : true;

        return left && right;

    }


    // 生成相邻不等的随机数组，用于验证
    public static int[] getRandomArray(int maxLength, int maxValue) {
        int len = (int) (Math.random() * maxLength);
        int[] ans = new int[len];
        // 先把arr[0]随机出来，用于比较
        // 可能摇出来0
        if (len > 0) {
            ans[0] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);

            for (int i = 1; i < ans.length; i++) {
                do {
                    // 先随机i位置的值
                    ans[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
                    // 再和前一个比较
                } while (ans[i] == ans[i - 1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxLength = 150;
        int maxValue = 500;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = getRandomArray(maxLength, maxValue);
            int index = localMinimum(arr);
            boolean ans = correctLocalMinimum(arr, index);

            if (!ans) {
                System.out.println("shit");
                System.out.println(Arrays.toString(arr));
                System.out.println("index = " + index);
                break;
            }
        }
        System.out.println("test finish");
    }

}
