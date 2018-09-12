package alg842;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<Integer> splitIntoFibonacci(String S) {
        int N = S.length();

        for (int i = 1; i < Math.min(N, 10); i++) {
            if (S.charAt(0) == '0' && i > 1) break;
            long num1 = Long.parseLong(S.substring(0, i));
            if (num1 > Integer.MAX_VALUE) break;

            search:
            for (int j = i + 1; j < Math.min(N, 10 + i); j++) {
                if (S.charAt(i) == '0' && j > i + 1) break;
                long num2 = Long.parseLong(S.substring(i, j));
                if (num2 > Integer.MAX_VALUE) break;

                List<Integer> result = new ArrayList<>();
                result.add((int) num1);
                result.add((int) num2);
                int k = j;
                while (k < N) {
                    long num3 = result.get(result.size() - 2) + result.get(result.size() - 1);
                    String s3 = String.valueOf((int) num3);
                    int n3 = s3.length();
                    if (S.substring(k).startsWith(s3) && num3 <= Integer.MAX_VALUE) {
                        result.add((int) num3);
                        k = k + n3;
                    } else
                        continue search;
                }
                if (result.size() >= 3)
                    return result;
            }
        }
        return new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        String S = "1201212";
        List<Integer> result = sol.splitIntoFibonacci(S);
        System.out.println(result);
    }
}
