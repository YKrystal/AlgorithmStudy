package class01;

/**
 * 给定一个随机函数f，等概率返回【1，5】，要求使用这个函数做一个等概率返回【1，7】的 </br>
 * 不能使用其他随机行为Math.random()
 *
 * @author YKrystal
 * @date 2021/5/27
 */
public class Code07_NumToNumRandom {

    // given  random function
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    // 获取0，1等概率发生器，比如：f1随机出3的时候重新随机
    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    // 看7需要几位二进制位，由0，1组成
    // 000 - 111 ===> [0,7]
    // 每次f2随机出来0和1，左移相应位数
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + (f2() << 0);
    }

    // 得到[0,6]等概率发生器
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    // 得到[1,7]
    public static int f5() {
        return f4() + 1;
    }

    public static void main(String[] args) {
        // test every function
        int testTime = 100000;
        int[] counts = new int[6];
        for (int i = 0; i < testTime; i++) {
            counts[f1()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("counts[" + i + "] = " + counts[i]);
        }
        System.out.println("----------------");

        counts = new int[2];
        for (int i = 0; i < testTime; i++) {
            counts[f2()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("counts[" + i + "] = " + counts[i]);
        }
        System.out.println("----------------");

        counts = new int[8];
        for (int i = 0; i < testTime; i++) {
            counts[f3()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("counts[" + i + "] = " + counts[i]);
        }
        System.out.println("----------------");

        counts = new int[7];
        for (int i = 0; i < testTime; i++) {
            counts[f4()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("counts[" + i + "] = " + counts[i]);
        }
        System.out.println("-----------------");


        counts = new int[8];
        for (int i = 0; i < testTime; i++) {
            counts[f5()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("counts[" + i + "] = " + counts[i]);
        }
    }
}
