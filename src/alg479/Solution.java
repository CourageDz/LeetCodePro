package alg479;

public class Solution {
    public int largestPalindrome(int n) {
        if(n==1)
            return 9;
        int mod=(int)Math.pow(10,n);
        int max=mod-1;
        long pro=(long)max * (long)max;
        int right=(int)(pro%mod);
        int left=(int)(pro/mod);
        if(left==reverse(right,n))return (int)(pro%1337);
        if(left>right)
            left--;
        pro=(long)left*(long)mod+(long)reverse(left,n);
        while (left!=mod/10){
            for (int i = max; i >pro/i ; i--) {
                if(pro%i==0)
                    return (int)(pro %1337);
            }
            left--;
            pro=(long)left*(long)mod+(long)reverse(left,n);
        }
        return -1;
    }
    public  int reverse(int num,int n){
        int temp=0;
        while (n>0){
            temp=temp*10+num%10;
            num=num/10;
            n--;
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution sol=new Solution();
        int result=sol.largestPalindrome(5);
//        int result=sol.reverse(12345,5);
        System.out.println(result);
    }

}
