package alg498;

public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0)
            return new int[0];
        int M = matrix.length;
        int N = matrix[0].length;
        int num[] = new int[M * N];
        int k = 0;
        int dir = 1;
        for (int i = 0; i < M + N - 1; i++) {
            if (dir == 1) {
                for (int l = 0; l <= i ; l++) {
                    if((i-l)<M && l<N){
                        num[k++] = matrix[i - l][l];
                    }else
                        continue;
                }
                dir = 0;
            } else {
                for (int l = 0; l <= i; l++) {
                    if(l<M && i-l<N){
                        num[k++] = matrix[l][i - l];
                    }else
                        continue;
                }
                dir = 1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        int [][]matrix={
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {1},{2},{3},
        };
        int []result=sol.findDiagonalOrder(matrix);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }
}
