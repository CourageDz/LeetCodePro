package alg778;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {
    private static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int swimInWater(int[][] grid) {
        int elevation = grid[0][0];
        int N = grid.length;
        boolean[][] isVisited = new boolean[N][N];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(N * N, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                return grid[x / N][x % N] - grid[y / N][y % N];
            }
        });
        pq.offer(0);
        isVisited[0][0] = true;
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            int curr_x = curr / N;
            int curr_y = curr % N;
            elevation = grid[curr_x][curr_y];
            //isVisited[curr_x][curr_y] = true;
            //System.out.println("pq poll(): ");
            if (bfs(grid, isVisited, pq, elevation, curr_x, curr_y)) return elevation;
        }
        return elevation;
    }

    private boolean bfs(int[][] grid, boolean[][] isVisited, PriorityQueue<Integer> pq, int h, int x, int y) {
        int N = grid.length;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x * N + y);
        isVisited[x][y] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == N * N - 1) return true;
            int curr_x = curr / N;
            int curr_y = curr % N;
            //System.out.println("curr_x: "+curr_x + " curr_y: "+curr_y);
            for (int i = 0; i < 4; i++) {
                x = curr_x + directions[i][0];
                y = curr_y + directions[i][1];
                if (x >= 0 && x < N && y >= 0 && y < N && !isVisited[x][y]) {
                    if (grid[x][y] <= h) q.offer(x * N + y);
                    else pq.offer(x * N + y);
                    isVisited[x][y] = true;
                }
            }
        }
        return false;
    }

}
