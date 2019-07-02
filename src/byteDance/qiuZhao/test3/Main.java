package byteDance.qiuZhao.test3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            int p=sc.nextInt();
            int[] tb=new int[n+2];
            for (int i = 1; i <=n ; i++) {
                tb[i]=sc.nextInt();
            }
            System.out.println(getMinTYNum(p,tb));


        }
    }

    private static int getMinTYNum(int p, int[] tb) {
        int n=tb.length;
        boolean[] ifVisit=new boolean[n];
        int count=0;
        int minCount=Integer.MAX_VALUE;
        return dfs(0,minCount,p,tb,ifVisit);
    }

    private static int dfs(int count,int minCount, int p, int[] tb, boolean[] ifVisit) {
        int n=tb.length-2;
        if(p==n+1 && minCount>count){
            minCount=count;
            return minCount;
        }

        int minD=(p-tb[p])<1 ? 1:(p-tb[p]);
        int maxD=(p+tb[p])>n ? n+1 : (p+tb[p]);

        for (int i = maxD; i >=minD ; i--) {
            if(!ifVisit[i]){
                ifVisit[i]=true;
                int cc=Integer.MAX_VALUE;
                if(count+1<minCount){
                    cc=dfs(count+1,minCount,i,tb,ifVisit);
                }
                if(cc<minCount){
                    minCount=cc;
                }
                ifVisit[i]=false;
            }
        }
        return minCount;
    }
}
