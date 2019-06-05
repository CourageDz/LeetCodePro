package algLearn.ziduanhe;

public class Solution {
    //得到一组数组内的最大子段和
    public int getMaxSumInArray(int[] array){
        int n=array.length;
        int sum=0;
        int tempSum=0;
        for (int i = 0; i <n ; i++) {
            if(tempSum>0){
                tempSum+=array[i];
            }else {
                tempSum=array[i];
            }
            if (tempSum > sum) {
                sum=tempSum;
            }
        }
        return sum;
    }

    //计算一个矩阵内的最大矩阵和
    public int getMaxSumInMatrix(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        int sum=0;
        int[] cSum=new int[n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                cSum[j]=0;
            }
            for (int j = i; j <m ; j++) {
                for (int k = 0; k <n ; k++) {
                    cSum[k]+=matrix[j][k];
                }
                int tempSum=getMaxSumInArray(cSum);
                if(tempSum>sum){
                    sum=tempSum;
                }
            }
        }
        return sum;
    }
}
