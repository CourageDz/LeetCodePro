package alg0619.test3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(getInvalid(n));
    }

    private static long getInvalid(int n) {
        boolean[] ifSkip=new boolean[n+1];
        long sum=1;
        int mod=1000000007;
        for (int i = 2; i <=n ; i++) {
            if(ifSkip[i])
                continue;
            int k=i+i;
            while (k<=n){
                ifSkip[k]=true;
                k+=i;
            }
            int count=0;
            long mi=i;
            while (mi<=n){
                mi*=i;
                count++;
            }
            sum*=(count+1)%mod;
        }
        return sum;
    }

}
