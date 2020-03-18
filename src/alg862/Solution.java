package alg862;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        long[] P = new long[n + 1];
        P[0] = 0;
        for (int i = 0; i < n; i++) {
            P[i + 1] = P[i] + (long) A[i];
        }
        int ans = n + 1;
        Deque<Integer> monoQue = new LinkedList<>();
        for (int i = 0; i < n + 1; i++) {
            while (!monoQue.isEmpty() && P[i] <= P[monoQue.getLast()])
                monoQue.pollLast();
            while (!monoQue.isEmpty() && P[i] >= P[monoQue.getFirst()] + K)
                ans = Math.min(ans, i - monoQue.pollFirst());
            monoQue.addLast(i);
        }
        return ans == n + 1 ? -1 : ans;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int A[] = {56, -21, 56, 35, -9};
        int result = sol.shortestSubarray(A, 61);
        System.out.println(result);
    }
}
