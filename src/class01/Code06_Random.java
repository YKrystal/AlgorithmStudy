package class01;

/**
 * 探讨Math.random()
 *
 * @author YKrystal
 * @date 2021/5/26
 */
public class Code06_Random {
    public static void main(String[] args) {
        // Math.random()，随机等概率返回[0.0, 1.0) 的一个double值
        int testTime = 100000;
        int count = 0;

        for (int i = 0; i < testTime; i++) {
            if (Math.random() < 0.613) {
                count++;
            }
        }
        System.out.println("probability = " + (count / (double) testTime));
        System.out.println("----------------");

        // Math.random() * n 随机等概率返回[0.0, n.0) 的一个double值
        count = 0;
        for (int i = 0; i < testTime; i++) {
            if (Math.random() * 8 < 3) {
                count++;
            }
        }
        System.out.println("expect = " + (3 / 8.0));
        System.out.println("probability = " + (count / (double) testTime));
        System.out.println("-----------------");

        // (int) (Math.random() * n) 随机等概率返回 [0, n - 1] 一个int值
        int[] counts = new int[10];
        for (int i = 0; i < testTime; i++) {
            int index = (int) (Math.random() * 10);
            counts[index]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println("counts[" + i + "] = " + counts[i]);
        }
        System.out.println("********************************************************");


        // Math.random() [0.0,1.0)等概率返回一个
        // [0,x) 范围上的数，出现的概率是x
        // 要把[0,x)上的数，出现的概率弄成x^2
        count = 0;
        for (int i = 0; i < testTime; i++) {
            if (xToXPower2() < 0.42) {
                count++;
            }
        }
        System.out.println("expect = " + Math.pow(0.42, 2));
        System.out.println("probability = " + (count / (double) testTime));
        System.out.println("-----------------");

        count = 0;
        for (int i = 0; i < testTime; i++) {
            if (xToXPower3() < 0.42) {
                count++;
            }
        }
        System.out.println("expect = " + Math.pow(0.42, 3));
        System.out.println("probability = " + (count / (double) testTime));
        System.out.println("-----------------");

        count = 0;
        for (int i = 0; i < testTime; i++) {
            if (powerMin() < 0.42) {
                count++;
            }
        }
        System.out.println("expect = " + (1 - Math.pow(1 - 0.42, 2)));
        System.out.println("probability = " + (count / (double) testTime));
        System.out.println("-----------------");
    }


    /**
     * 返回[0,1)的一个小数，任意的x，x属于[0,1)，[0,x)范围上的数出现概率由原来的x调整成x平方
     * 两次随机行为是独立的，两次都在[0,x)范围内，取max也在[0,x)范围内，符合要求
     *
     * @return
     */
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    public static double xToXPower3() {
        return Math.max(Math.max(Math.random(), Math.random()), Math.random());
    }


    // 为什么不是min？

    /**
     * 第一次random() < 0.42
     * 第二次random() > 0.42
     * 取min，结果仍会返回<0.42，但不是x^2，而是1-(1 - x)^2 = 1 - (1 - 2x + x^2) = 2x - x^2
     *
     * @return
     */
    public static double powerMin() {
        return Math.min(Math.random(), Math.random());
    }

}
