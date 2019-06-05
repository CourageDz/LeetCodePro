package algLearn.quickSort;

public class Solution {
    public void quickSort(int[] array, int left,int right){
        if(left<right){
            int temp=array[left];
            int i=left,j=right;
            while (i<j){
                while (i<j && array[j]>=temp){
                    j--;
                }
                if(i<j){
                    array[i++]=array[j];
                }
                while (i<j&&array[i]<=temp){
                    i++;
                }

                if(i<j){
                    array[j--]=array[i];
                }
            }
            array[i]=temp;
            quickSort(array,left,i-1);
            quickSort(array,i+1,right);
        }
    }

    //计算一个数组内的最大的m个子段和
    public  int getMaxMSumInArray(int[] array,int m){
        int n=array.length;
        int[][] tempSum=new int[n+1][m+1];

        for (int i = 1; i <=m ; i++) {
            for (int j = i; j <=n-m+i ; j++) {
                if(j>i){
                    tempSum[j][i]=tempSum[j-1][i]+array[j-1];
                    for (int k = i-1; k <j ; k++) {
                        int tempS=tempSum[k][i-1]+array[j-1];
                        if(tempS>tempSum[j][i]){
                            tempSum[j][i]=tempS;
                        }
                    }
                }else {
                    tempSum[j][i]=tempSum[j-1][i-1]+array[j-1];
                }
            }
        }
        int sum=0;
        for (int i = m; i <=n ; i++) {
            if(tempSum[i][m]>sum){
                sum=tempSum[i][m];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution sol=new Solution();
        int[] array={1,2,-6,4,5,-7,3,2,1};
        int result=sol.getMaxMSumInArray(array,3);
        System.out.println(result);
    }
}
