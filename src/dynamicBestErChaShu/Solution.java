package dynamicBestErChaShu;

import java.util.Arrays;

public class Solution {
    public double cost(double[]p,double []q){
        int i,j,n;
        n=p.length-1;
        double [][]e=new double[n+2][n+1];
        double [][]w=new double[n+2][n+1];
        int root[][]=new int [n+1][n+1];

        for (int k = 1; k <=n ; k++) {
            e[k][k-1]=q[k-1];
            w[k][k-1]=q[k-1];
        }
        for (int l = 1;  l<=n; ++l) {
            for (i = 1; i <=n-l+1 ; i++) {
                 j=i+l-1;
                 w[i][j]=w[i][j-1]+p[j]+q[j];
                 e[i][j]=(double)Integer.MAX_VALUE;
                for (int k = i; k <=j ; k++) {
                    double t=e[i][k-1]+e[k+1][j]+w[i][j];
                    if(t<e[i][j]){
                        e[i][j]=t;
                        root[i][j]=k;
                    }
                }
            }
        }
        printRoot(root,1,n);
        return  e[1][n];
    }

    public void printRoot(int [][]root,int i,int j){
        if(i==j){
            System.out.println(i+"→ ");
            return;
        }
        if(i>j)
            return;
        int k=root[i][j];
        printRoot(root,i,k-1);
        System.out.println("("+k+") ");
        printRoot(root,k+1,j);
    }
    public static void main(String[] args) {
        Solution sol =new Solution();
        double p[]={0,0.15,0.1,0.05,0.1,0.2};
        double q[]={0.05,0.1,0.05,0.05,0.05,0.1};
        double result =sol.cost(p,q);
        System.out.println(result);

    }
}
