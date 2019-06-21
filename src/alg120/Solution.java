package alg120;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/***
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][]dp =new int[n+1][n+2];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[1][1]=triangle.get(0).get(0);
        for(int i=2;i<=n;i++){
            List<Integer> arrays=triangle.get(i-1);
            for(int j=1;j<=arrays.size();j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1]) + arrays.get(j-1);
            }
        }

        int min=Integer.MAX_VALUE;
        for(int i=1;i<=triangle.get(n-1).size();i++){
            if(min>dp[n][i]){
                min=dp[n][i];
            }
        }
        return min;
    }
}
