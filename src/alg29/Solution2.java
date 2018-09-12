package alg29;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int divide(int dividend, int divisor) {
        if(dividend==-2147483648&&Math.abs(divisor)==1){
            return 2147483647;
        }
        List<Long> divisorList =new ArrayList<>();
        int flag1=dividend>0 ?1:0;
        int flag2=divisor>0 ? 1:0;

        long absDividend=Math.abs(dividend);
        long absDivisor=Math.abs(divisor);
        int sum=0,iCount=0;
        long i=1;
        divisorList.add(absDivisor);
        while (absDividend >= absDivisor){
            absDivisor+=absDivisor;
            i+=i;
            divisorList.add(absDivisor);
        }

        i>>=1;
        for (int j = divisorList.size()-2; j >=0 ; j--) {

            if(sum+divisorList.get(j)<=absDividend

            ){
                iCount+=i;
                sum+=divisorList.get(j);
            }
            i>>=1;
        }
        if(flag1+flag2==1){
            return -iCount;
        }
        return iCount;
    }
    public static void main(String[] args) {
        Solution2 sol =new Solution2();
        int result=sol.divide(2147483647,1);
        System.out.println(result);
    }
}