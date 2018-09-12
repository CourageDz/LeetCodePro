package alg842;

import java.util.*;

public class Solution {
    class Sol{
        int n;
        String S;
        String s1;
        int num1;
        int num2;
        int j;
        Sol(String s){
            this.S=s;
            this.n=s.length();
        }
    }
    public List<Integer> splitIntoFibonacci(String S) {
        int n=S.length();
        Sol sol=new Sol(S);
        List<Integer> result=new ArrayList<>();
        for (int i = 1; i <13 &&i<S.length() ; i++) {
            for (int j = i+1; (j-i) <13 && j<S.length() ; j++) {
                sol.num1=Integer.parseInt(S.substring(0,i));
                sol.num2=Integer.parseInt(S.substring(i,j));
                sol.s1=S.substring(0,j);
                sol.j=j;
                result.add(sol.num1);
                result.add(sol.num2);
                if(backtrace(sol,result))
                    return result;
                else
                    result.clear();
            }
        }
        return result;

    }

    public boolean backtrace(Sol sol,List<Integer> result){
        int num3=sol.num1+sol.num2;
        String has=sol.s1+String.valueOf(num3);
        int n=has.length()-sol.s1.length();
        if(sol.S.length()<has.length()){
            return false;
        }
        else if(sol.S.equals(has)){
            result.add(num3);
            return true;
        }
        if(sol.S.substring(0,sol.j+n).equals(has)){
            sol.j=sol.j+n;
            result.add(num3);
            sol.num1=sol.num2;
            sol.num2=num3;
            sol.s1=has;
            backtrace(sol,result);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        String S="214748364721474836422147483641";
//        List<Integer> result=sol.splitIntoFibonacci(S);
        System.out.println(Integer.MAX_VALUE);
    }
}

