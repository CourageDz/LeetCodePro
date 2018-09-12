package alg5;

import java.util.Scanner;

public class Solution {
    //暴力解法
    public String longestPalindrome(String s) {
        int n =s.length(),max=0,startJ=0;
        for(int i=1;i<=n;i++){
            for (int j=0;j<=n-i;j++){
                String ss=s.substring(j,j+i);
                if(isPalindrome(ss)){
                    max=i;
                    startJ=j;
                }
            }
        }
        return s.substring(startJ,startJ+max);
    }

    public static boolean isPalindrome(String s){
        int n=s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i) != s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s=sc.nextLine();
        Solution sol =new Solution();
        String ss=sol.longestPalindrome(s);
        System.out.println(ss);

    }

}
