package alg10;

import java.util.Scanner;

public class Solution {
    private static int FRONT=-1;
    public boolean isMatch(String s, String p) {
        return myMatch(s,s.length()-1,p,p.length()-1);
    }
    public boolean myMatch(String s,int i,String p,int j){
        if(j==FRONT){
            if(i==FRONT)
                return true;
            else return false;
        }
        if(p.charAt(j)=='*'){
            if(i>FRONT && (s.charAt(i)==p.charAt(j-1)|| p.charAt(j-1)=='.')){
                if(myMatch(s,i-1,p,j))
                    return true;
            }
            return myMatch(s,i,p,j-2);
        }
        if(i>FRONT&&(p.charAt(j)=='.'||p.charAt(j)==s.charAt(i))){
            return myMatch(s,i-1,p,j-1);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s =sc.nextLine();
        String p =sc.nextLine();
        Solution sol =new Solution();
        boolean isM=sol.isMatch(s,p);
        System.out.println(isM);
    }
}
