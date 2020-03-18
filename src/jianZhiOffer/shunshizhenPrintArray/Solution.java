package jianZhiOffer.shunshizhenPrintArray;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null) {
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int rs = 0, re = m - 1, cs = 0, ce = n - 1;
        while (re >= rs && ce >= cs) {
            for (int i = cs; i <= ce; i++) {
                list.add(matrix[rs][i]);
            }
            for (int i = rs + 1; i <= re; i++) {
                list.add(matrix[i][ce]);
            }
            if (rs != re) {
                for (int i = ce - 1; i >= cs; i--) {
                    list.add(matrix[re][i]);
                }
            }

            if (ce != cs) {
                for (int i = re - 1; i > rs; i--) {
                    list.add(matrix[i][cs]);
                }
            }
            rs++;
            cs++;
            re--;
            ce--;
        }
        return list;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] array = {{1, 2}, {3, 4}};
        ArrayList<Integer> result = sol.printMatrix(array);
        System.out.println(result.toString());
    }
}