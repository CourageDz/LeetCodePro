package alg59;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int ri = 0, rj = n - 1;
        int ci = 0, cj = n - 1;
        int k = 0;
        int l, t;
        while (ci <= cj && ri <= rj) {
            for (l = ci; l <= cj; l++) {
                matrix[ri][l] = ++k;
            }
            ri++;
            for (t = ri; t <= rj; t++) {
                matrix[t][cj] = ++k;
            }
            cj--;
            for (l = cj; l >= ci; l--) {
                matrix[rj][l] = ++k;
            }
            rj--;
            for (t = rj; t >= ri; t--) {
                matrix[t][ci] = ++k;
            }
            ci++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4;
        int results[][] = sol.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(results[i][j] + " ");
            }
            System.out.println();
        }
    }
}

