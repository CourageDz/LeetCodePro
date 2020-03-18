package alg402;

public class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k >= n)
            return "0";
        if (k == 0)
            return num;
        int count = 0;
        int i = 1;
        StringBuffer sb = new StringBuffer(num);
        while (i < sb.length()) {
            while (i < sb.length() && sb.charAt(i) >= sb.charAt(i - 1)) {
                i++;
            }
            sb.deleteCharAt(i - 1);
            if (i >= sb.length())
                i--;
            count++;
            if (count == k)
                break;
            if (i > 1)
                i--;
        }
        while (sb.charAt(0) == '0' && sb.length() > 1)
            sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String num = "12345";
        String result = sol.removeKdigits(num, 0);
        System.out.println(result);
    }
}
