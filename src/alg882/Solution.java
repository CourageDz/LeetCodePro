package alg882;


public class Solution {
    public int count=0;
    public int reachableNodes(int[][] edges, int M, int N) {
        int n=edges.length;

        int len=0;
        for (int i = 0; i <n ; i++) {
            if(edges[i][0]==0){
                len=M;
                if(edges[i][2]>=len)
                    count+=len;
                else {
                    int j=edges[i][1];
                    count+=edges[i][2];
                    len-=edges[i][2];

                }
            }
        }
    }
    public int nodeDistance(int[][]edges,int k,int M,int N){
        int n=edges.length;
        for (int i = 0; i <n ; i++) {
            int len =M;
            if(edges[i][0]>k)
        }
    }
}
