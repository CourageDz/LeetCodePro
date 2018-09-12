package alg5;
import java.util.*;

public class Solution2 {
    //动态规划
    public String longestPalindrome(String s) {
        int i,j,n,k;
        int maxi=0,maxj=0;
        n=s.length();
        boolean [][]p=new boolean[n][n];
        //init p[][]标记
        for(i=0;i<n;i++){
            for(j=0;j<n;j++) {
                p[i][j]=false;
            }
        }
        for(i=0;i<n;i++){
            p[i][i]=true;
        }
        for (j = 1; j <n ; j++) {
            for ( i = 0; i <n-j ; i++) {
                k=i+j;
                if(j==1){
                    if(s.charAt(i)==s.charAt(k)){
                        p[i][k]=true;
                        maxi=i;
                        maxj=k;
                    }
                }else{
                    if(p[i+1][k-1]==true&&s.charAt(i)==s.charAt(k)){
                        p[i][k]=true;
                        maxi=i;
                        maxj=k;
                    }
                }
            }
        }
        return s.substring(maxi,maxj+1);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s =sc.nextLine();
        Solution2 sol =new Solution2();
        String ss=sol.longestPalindrome(s);
        System.out.println(ss);
    }
}
