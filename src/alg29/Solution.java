package alg29;

public class Solution {
    public int divide(int dividend, int divisor) {
        //通过被除数减去除数完成，耗时较大，例如10000,1
        int count=0;
        if(dividend == -2147483648 && divisor == 1){
            //防止溢出
            return 2147483647;
        }
        if(dividend==0){
            return 0;
        }
        if((dividend>0 &&divisor<0)||(dividend<0 && divisor>0)){
            while (Math.abs(dividend)>=Math.abs(divisor)){
                dividend=divisor+dividend;
                count++;
            }
            return -count;
        }else {
            while (Math.abs(dividend)>=Math.abs(divisor)){
                dividend=dividend-divisor;
                count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        int result=sol.divide(-2147483648,1);
        System.out.println(result);
    }
}
