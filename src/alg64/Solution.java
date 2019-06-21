package alg64;

/***
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n+1][m+1];
        dp[1][1]=grid[0][0];
        if(n>1){
            for(int i=2;i<=n;i++){
                dp[i][1]=grid[i-1][0]+dp[i-1][1];
            }
        }
        if(m>1){
            for(int i=2;i<=m;i++){
                dp[1][i]=dp[1][i-1]+grid[0][i-1];
            }
        }

        if(n>1){
            for(int i=2;i<=n;i++){
                if(m>1){
                    for(int j=2;j<=m;j++){
                        dp[i][j]=((dp[i-1][j]<dp[i][j-1])?dp[i-1][j]:dp[i][j-1])+grid[i-1][j-1];
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution sol=new Solution();
        int[][] array={{1,3,1},
                {1,5,1},
                {4,2,1}};
        System.out.println(sol.minPathSum(array));
    }
}
