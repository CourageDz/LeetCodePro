package alg6;

import java.util.Scanner;

public class Solution {
    public String convert(String s, int numRows) {
        int n=s.length();
        int column=n/2;
        int t=0;
        boolean flag=false;
        char p[][]=new char [numRows][n];
        int k=0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < column; j++) {
                p[i][j]='*';
            }
        }
        flag=true;
        for (int i = 0; i <n; ) {
            if(flag){
                for (int j = 0; i<n&&j < numRows; j++) {
                    p[j][t]=s.charAt(i);
                    i++;
                }
                flag=false;
            }else{
                for (int j = numRows-2;i<n && j >0 ; j--) {
                    t++;
                    p[j][t]=s.charAt(i);
                    i++;
                }
                flag=true;
                t++;
            }
        }
        char sArray[]=new char[n];
        t=0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < column; j++) {
                if(p[i][j]!='*'){
                   sArray[t++]=p[i][j];
                }
            }
        }
        String ss=String.valueOf(sArray);
        return ss;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s =sc.nextLine();
        int num =sc.nextInt();
        Solution sol =new Solution();
        String ss=sol.convert(s,num);
        System.out.println(ss);
    }
}
