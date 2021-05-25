package class01;

/**
 * 前缀和数组，对于频繁的查询数组中i到j位置的和，直接取值
 *
 * @author YKrystal
 * @date 2021/5/25
 */
public class Code05_PreSum {
    public static int getSum(int[] arr, int left, int right) {
        if (left > right) {
            throw new RuntimeException("wrong parameters: left and right");
        }
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("wrong array");
        }

        // 得到前缀和数组
        int[] preSum = new int[arr.length];
        preSum[0] = arr[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }

        // 返回结果
        return left == 0 ? preSum[right] : preSum[right] - preSum[left - 1];
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 7, 2, 0, 9, 6};
        System.out.println(getSum(arr, 0, 4));
        System.out.println(getSum(arr, 2, 6));
    }
}
