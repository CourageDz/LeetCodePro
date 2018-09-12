package dynamicImageC;

public class Solution {
    public void compress(int n,int p[],int s[],int l[],int b[]){
        int Lmax=256,head=11;
        s[0]=0;
        for (int i = 1; i <=n ; i++) {
            b[i]=length(p[i]);
            int bmax=b[i];
            s[i]=s[i-1]+bmax;
            l[i]=1;
            for (int j = 2; j <=i && j<=Lmax ; j++) {
                if(bmax< b[i-j+1]) bmax=b[i-j+1];
                if(s[i]> s[i-j]+j*bmax){
                    s[i]=s[i-j]+j*bmax;
                    l[i]=j;
                }
            }
            s[i]+=head;
        }
    }
    public int length(int p){
        int i=1;p/=2;
        while (p>0){
            p/=2;
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int p[]={0,10,12,15,255,1,2};
        Solution sol =new Solution();
        int n=p.length;
        int s[]=new int[n];
        int l[]=new int[n];
        int b[]=new int[n];
        sol.compress(n-1,p,s,l,b);
        System.out.println(s[n-1]);
    }
}
