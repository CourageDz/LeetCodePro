package algLearn.packageProblemDP;

public class Solution {
    public static int getMaxValue(int c,int[] v,int[]w,int n){
        int[][] values=new int[n+1][c+1];

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=c ; j++) {
                if(j>=w[i-1]){
                    int addGood=values[i-1][j-w[i-1]]+v[i-1];
                    values[i][j]=(addGood>values[i-1][j])?addGood:values[i-1][j];
                }else {
                    values[i][j]=values[i-1][j];
                }
            }
        }
        return values[n][c];
    }

    public static void main(String[] args) {
        int val[] = {200, 250, 140,150};
        int wt[] = {1, 3, 2,5};
        int c = 5;
        int n = val.length;
        System.out.printf("%d",getMaxValue(c,val,wt,n));
    }
}
