package alg639;

import java.util.Arrays;

public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        long num[] = new long[n + 1];
        Arrays.fill(num, 0);
        int subNum = (int) Math.pow(10, 9) + 7;
        num[0] = 1;
        num[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) != '0' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                num[i + 1] = 9 * num[i] % subNum;
                if (s.charAt(i - 1) == '1')
                    num[i + 1] = (num[i + 1] + 9 * num[i - 1]) % subNum;
                else if (s.charAt(i - 1) == '2')
                    num[i + 1] = (num[i + 1] + 6 * num[i - 1]) % subNum;
                else if (s.charAt(i - 1) == '*')
                    num[i + 1] = (num[i + 1] + 15 * num[i - 1]) % subNum;
            } else {
                num[i + 1] = c != '0' ? num[i] : 0;
                if (s.charAt(i - 1) == '2' && c <= '6')
                    num[i + 1] = (num[i + 1] + num[i - 1]) % subNum;
                else if (s.charAt(i - 1) == '1')
                    num[i + 1] = (num[i + 1] + num[i - 1]) % subNum;
                else if (s.charAt(i - 1) == '*')
                    num[i + 1] = (num[i + 1] + (c <= '6' ? 2 : 1) * num[i - 1]) % subNum;
            }
        }
        return (int) num[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "*0*";
        int result = sol.numDecodings(s);
        System.out.println(result);
    }
}
