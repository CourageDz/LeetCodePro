package alg43;

import java.util.Arrays;

public class Solution {
    public String multiply(String num1, String num2) {
        int n=num1.length(),m=num2.length();
        int pos[]=new int [n+m];
        Arrays.fill(pos,0);
        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >=0 ; j--) {
                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum=mul+pos[i+j+1];

                pos[i+j+1]=sum%10;
                pos[i+j]+=sum/10;
            }
        }
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i <n+m ; i++) {
            if(!(sb.length()==0 && pos[i]==0))
                sb.append(pos[i]);
        }
        if(sb.length()==0)
            return "0";
        else
            return  sb.toString();
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        String num1="123";
        String num2="45";
        String result=sol.multiply(num1,num2);
        System.out.println(result);
    }
}
