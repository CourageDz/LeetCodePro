package alg908;

public class Solution {
    public int smallestRangeI(int[] A, int K) {
        int n = A.length;
        int leftNum[] = new int[n];
        int rightNum[] = new int[n];
        for (int i = 0; i < n; i++) {
            leftNum[i] = A[i] - K;
            rightNum[i] = A[i] + K;
        }
        int maxLeft = Integer.MIN_VALUE, minRight = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (leftNum[i] > maxLeft)
                maxLeft = leftNum[i];
            if (rightNum[i] < minRight)
                minRight = rightNum[i];
        }
        if (maxLeft > minRight)
            return maxLeft - minRight;
        else
            return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int A[] = {0, 10};
        int result = sol.smallestRangeI(A, 2);
        System.out.println(result);
    }
}
