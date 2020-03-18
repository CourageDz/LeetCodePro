package alg201;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        String s1 = Integer.toBinaryString(m);
        int len1 = s1.length();
        String s2 = Integer.toBinaryString(n);
        int len2 = s2.length();
        if (len1 != len2)
            return 0;
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (; i < len1; i++) {
            if (s1.charAt(i) == s2.charAt(i))
                sb.append(s1.charAt(i));
            else
                break;
        }
        for (int j = i; j < len1; j++) {
            sb.append("0");
        }
        return Integer.valueOf(sb.toString(), 2);
    }

    public int rangeBitwiseAndEasy(int m, int n) {
        int i = 0; // i means we have how many bits are 0 on the right
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.rangeBitwiseAnd(8, 10);
        System.out.println(result);
    }
}
