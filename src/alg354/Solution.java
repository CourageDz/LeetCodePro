package alg354;

import java.util.Arrays;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Envelope envelope[] = new Envelope[envelopes.length + 1];
        envelope[0] = new Envelope(0, 0);
        for (int i = 0; i < envelopes.length; i++) {
            envelope[i + 1] = new Envelope(envelopes[i][0], envelopes[i][1]);
        }
        Arrays.sort(envelope, (a, b) -> {
            if (a.width == b.width)
                return a.length - b.length;
            else
                return a.width - b.width;
        });
        int dp[] = new int[envelopes.length + 1];
        dp[0] = 0;
        for (int i = 1; i < envelope.length; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (envelope[i].width > envelope[j].width && envelope[i].length > envelope[j].length) {
                    dp[i] = Math.max((dp[j] + 1), dp[i]);
                    j--;
                } else
                    j--;
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    class Envelope {
        int width;
        int length;

        public Envelope(int w, int l) {
            width = w;
            length = l;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int arrays[][] = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3},
        };
        int result = sol.maxEnvelopes(arrays);
        System.out.println(result);
    }
}
