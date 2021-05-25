package class01;

/**
 * 打印一个整数的32位二进制信息
 */
public class Code01_PrintBinary {
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            printBinary(i);
        }
    }
}
