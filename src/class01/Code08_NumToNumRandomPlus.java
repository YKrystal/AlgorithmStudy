package class01;

/**
 * f()随机返回0，1，但概率不等 ,得到一个0，1概率相等的
 *
 * @author YKrystal
 * @date 2021/5/27
 */
public class Code08_NumToNumRandomPlus {

    // given random function
    public static int g1() {
        return Math.random() < 0.34 ? 0 : 1;
    }

    // 相同就重做
    // 10 和 01 符合，此时的概率是p * (1 - p)
    public static int g2() {
        int ans = 0;
        do {
            ans = g1();
        } while (ans == g1());
        return ans;
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int[] counts = new int[2];
        for (int i = 0; i < testTime; i++) {
            counts[g1()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("counts[" + i + "] = " + counts[i]);
        }
        System.out.println("------------------");

        counts = new int[2];
        for (int i = 0; i < testTime; i++) {
            counts[g2()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("counts[" + i + "] = " + counts[i]);
        }
    }

}
