package simulation0803.t3;

public class Main {
    public static void main(String[] args) {
        System.out.println(lowbit(5));
    }

    private static int lowbit(int x) {
        return x & (-x);
    }
}
