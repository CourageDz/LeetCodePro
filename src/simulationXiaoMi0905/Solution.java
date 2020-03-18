package simulationXiaoMi0905;

public class Solution {
    public static long getResult(long n) {
        long x = 5;
        long sum = 0;
        while (sum < n) {
            sum += x;
            x *= 2;
        }
        sum -= x / 2;
        return n - sum;
    }

    public static void main(String[] args) {
        long n = 22;
        System.out.println(getResult(n));
    }
}
