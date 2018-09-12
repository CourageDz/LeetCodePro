package alg372;

public class Solution {
    public int superPow(int a, int[] b) {
        if(a%1337==0)
            return 0;
        int n=b.length;
        int param=0;
        for (int i = 0; i <n ; i++) {
            param=(param*10+b[i]) %1140;
        }
        a=a%1337;
        param=param%1140;
        if(param==0)
            param=1140;
        return pow(a,param);
    }
    public int pow(int a,int b){
        int ret=1;
        while (b!=0){
            if((b & 1)!=0)
                ret=ret*a%1337;
            a=a*a % 1337;
            b>>=1;
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution sol=new Solution();
        int b[]={7,8};
        int result=sol.superPow(2,b);
        System.out.println(result);
    }
}
