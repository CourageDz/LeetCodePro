package alg240;

public class Solution {
    //Time limit exceeded
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null)
            return false;
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        boolean isVist[][] = new boolean[matrix.length][matrix[0].length];
//        for (int i = 0; i <matrix.length ; i++) {
//            Arrays.fill(isVist[i],false);
//        }
        return dfs(matrix, isVist, 0, 0, target);
    }

    public boolean dfs(int[][] matrix, boolean[][] isVist, int i, int j, int target) {
        if (isVist[i][j] == true)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        isVist[i][j] = true;
        if (matrix[i][j] == target)
            return true;
        if (j <= n - 2 && matrix[i][j + 1] == target)
            return true;
        else if (j <= n - 2 && matrix[i][j + 1] < target) {
            if (dfs(matrix, isVist, i, j + 1, target))
                return true;
        }
        if (i == m - 1)
            return false;
        else if (matrix[i + 1][j] == target)
            return true;
        else if (matrix[i + 1][j] < target && i != m - 2) {
            if (dfs(matrix, isVist, i + 1, j, target))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
//                {}
        };
        boolean result = sol.searchMatrix(matrix, 6);
        System.out.println(result);
    }
}
