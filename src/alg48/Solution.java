package alg48;

import sun.java2d.pipe.SolidTextRenderer;

public class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        for (int i = 0; i <n ; i++) {
            for (int j = i; j <n ; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        int l=0,r=n-1;
        while (l<=r){
            int temp[]=new int [n];
            for (int k = 0; k <n ; k++) {
                temp[k]=matrix[k][l];
            }
            for (int i = 0; i <n ; i++) {
                matrix[i][l]=matrix[i][r];
                matrix[i][r]=temp[i];
            }
            l++;
            r--;
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Solution sol =new Solution();
        int matrix[][]={{1,2,3},{4,5,6},{7,8,9}};
        sol.rotate(matrix);
    }
}
