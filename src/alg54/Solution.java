package alg54;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //另一种解法：设立两个数组，分别表示方向，同时设置boolean seen[][]表示是否已经添加
    //第一行扫描的时候扫到底，第一列扫描的时候也扫到底
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        List<Integer> nums = new ArrayList<>();
        if (m == 0) return nums;
        int n = matrix[0].length;
        int ci = 0, cj = n-1, ri = 0, rj = m - 1;
        while(ci<=cj && ri<=rj) {
            for (int i = ci; i<= cj; i++) {
                nums.add(matrix[ri][i]);
            }
            for (int k = ri+1; k <=rj; k++) {
                nums.add(matrix[k][cj]);
            }
            if(ci<cj && ri<rj){
                for (int l = cj-1; l > ci; l--) {
                    nums.add(matrix[rj][l]);
                }
                for (int t = rj; t > ri; t--) {
                    nums.add(matrix[t][ci]);
                }
            }

            ri++;
            rj--;
            ci++;
            cj--;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int matrix[][] = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {1, 2, 3 },
//                {4, 5, 6 },
//                { 7, 8, 9 },
                {2},
                {3},
        };

        List<Integer> result = sol.spiralOrder(matrix);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
