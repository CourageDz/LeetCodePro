package alg397;

public class Solution {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if (n % 2 == 1) {
                count++;
                if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1))
                    n--;
                else
                    n++;
            } else {
                count++;
                n >>>= 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.integerReplacement(Integer.MAX_VALUE + 1);
        System.out.println(result);
    }
}
