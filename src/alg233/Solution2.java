package alg233;

public class Solution2 {
    public int countDigitOne(int n) {
        long x = 10;
        int count = 0;
        while (n >= (x / 10)) {
            count += (n / x) * (x / 10) + Math.min(Math.max(n % x - (x / 10) + 1, 0), x / 10);
            x = x * 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int result = sol.countDigitOne(100);
        System.out.println(result);
    }
}
