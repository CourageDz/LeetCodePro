package alg547;

public class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int p = find(i, uf);
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    union(p, j, uf);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (uf[i] == i)
                count++;
        }
        return count;
    }

    private void union(int i, int j, int[] uf) {
        int p = find(i, uf);
        int q = find(j, uf);

        if (p == q) {
            return;
        }
//        for (int i = 0; i <uf.length ; i++) {
//            if(uf[i]==uf[p])
//                uf[i]=uf[q];
//        }
        uf[p] = uf[q];
    }

    private int find(int i, int[] uf) {
        while (uf[i] != i) {
            i = uf[i];
        }
        return i;
    }
}
