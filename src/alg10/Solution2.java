package alg10;

import java.util.Arrays;

public class Solution2 {
    public boolean isMatch(String s, String p) {
        int m=s.length(),n=p.length();
        boolean sp[][]=new boolean[m+1][n+1];
        sp[0][0]=true;
        for (int i = 1; i <m+1 ; i++) {
            sp[i][0]=false;
        }
        for (int i = 1; i <n+1 ; i++) {
            sp[0][i]=i>1&&p.charAt(i-1)=='*'&&sp[0][i-2];
        }
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(p.charAt(j-1)=='*'){
                        sp[i][j]=sp[i][j-2]||(s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.')&&sp[i][j-1];
                }
                sp[i][j]=(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')&&sp[i-1][j-1];
            }
        }
        return sp[m][n];
    }
}
