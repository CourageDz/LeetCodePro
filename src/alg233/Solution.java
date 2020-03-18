package alg233;

public class Solution {
    //time limited
    public int countDigitOne(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            count += isContainOne(s);
        }
        return count;
    }

    public int isContainOne(String s) {
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                num++;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.countDigitOne(130);
        System.out.println(result);
    }
}
