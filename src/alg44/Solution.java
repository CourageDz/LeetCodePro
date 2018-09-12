package alg44;

import sun.java2d.pipe.SolidTextRenderer;

import java.util.Arrays;

public class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean match[][]=new boolean [n+1][m+1];
        match[0][0]=true;//两个字符串都为0，所以匹配
        for (int i = 1; i <=n ; i++) {
            match[i][0]=false;
        }
        for (int i = 1; i <=m ; i++) {
            if(p.charAt(i-1)=='*'){
                match[0][i]=match[0][i-1];
            }
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='?')
                    match[i][j]=match[i-1][j-1] ;
                else if(p.charAt(j-1)=='*'){
                    match[i][j]=match[i-1][j]||match[i][j-1];
                }
            }
        }
        return match[n][m];
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        String s="abcds";
        String p="a*b";
        boolean result=sol.isMatch(s,p);
        System.out.println(result);
    }
}
