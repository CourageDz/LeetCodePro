package alg50;

public class Solution {
    //利用递归
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if (n<0){
            x=1/x;
            n=-n;
        }
        if(n%2==0){
            return myPow(x*x,n/2);
        }
        else {
            return x*myPow(x*x,n/2);
        }
    }

    public static void main(String[] args) {
        Solution sol=new Solution();
        double result=sol.myPow(2,-2);
        System.out.println(result);
    }
}
