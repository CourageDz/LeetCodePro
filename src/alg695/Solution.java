package alg695;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        boolean[][] isVisit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int area = getAreaOfNode(grid, i, j, n, m, isVisit);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    public int getAreaOfNode(int[][] grid, int i, int j, int n, int m, boolean[][] isVisit) {
        if (grid[i][j] == 0 || isVisit[i][j])
            return 0;
        else {
            Queue<Integer> area = new LinkedList<>();
            int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            area.offer(i * m + j);
            int count = 0;
            while (!area.isEmpty()) {
                int num = area.poll();
                int x = num / m;
                int y = num % m;
                if (isVisit[x][y])
                    continue;
                isVisit[x][y] = true;
                count++;
                for (int k = 0; k < 4; k++) {
                    int xx = x + dir[k][0];
                    int yy = y + dir[k][1];
                    if (xx < n && xx >= 0 && yy < m && yy >= 0) {
                        if (grid[xx][yy] == 1 && !isVisit[xx][yy]) {
                            area.offer(xx * m + yy);
                        }
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[][]grid={
//                {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0} };
        int[][] grid = {
                {1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}
        };
        int result = sol.maxAreaOfIsland(grid);
        System.out.println(result);
    }
}
