package threadTest;

public class Test {
    public static void main(String[] args) {
        int num = -8;
        System.out.println("移位前：num= " + num + "  二进制为：" + Integer.toBinaryString(num));
        num = num >> 2;
        System.out.println("移位后：num= " + num + "  二进制为： " + Integer.toBinaryString(num));
    }
}
