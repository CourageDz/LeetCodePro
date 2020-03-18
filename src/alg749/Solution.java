package alg749;

import java.util.*;

public class Solution {
    class Virus {
        List<Integer> virusRegion;
        List<Integer> threatRegion;
        int wall;

        public Virus(int w, List<Integer> v, List<Integer> t) {
            wall = w;
            virusRegion = v;
            threatRegion = t;
        }
    }

    public int containVirus(int[][] grid) {
        if (grid == null || (grid.length == 1 && grid[0].length == 1))
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int walls = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Virus> viruss = new PriorityQueue<>((a, b) -> b.threatRegion.size() - a.threatRegion.size());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    List<Integer> virusRegion = new ArrayList<>();
                    List<Integer> threatRegion = new ArrayList<>();
                    int x = i * n + j;
                    int wall = bfs(grid, x, threatRegion, virusRegion, visited);
                    Virus virus = new Virus(wall, virusRegion, threatRegion);
                    viruss.add(virus);
//                    clearVisitedFlag(visited,threatRegion);
                }
            }
        }

        Virus maxVirus = viruss.poll();
        walls += maxVirus.wall;
        changeVirusStatus(grid, maxVirus.virusRegion);
        if (viruss.isEmpty())
            return walls;
        else
            spreadVirus(grid, viruss);
        walls += containVirus(grid);
        return walls;
    }

    public void changeVirusStatus(int[][] grid, List<Integer> virusRegion) {
        int n = grid[0].length;
        for (Integer node : virusRegion) {
            int x = node / n;
            int y = node % n;
            grid[x][y] = -1;
        }
    }

    public void spreadVirus(int[][] grid, Queue<Virus> threatRegions) {
        int n = grid[0].length;
        int k = threatRegions.size();
        for (int i = 0; i < k; i++) {
            Virus virus = threatRegions.poll();
            for (Integer node : virus.threatRegion) {
                int x = node / n;
                int y = node % n;
                grid[x][y] = 1;
            }
        }
    }

    public int bfs(int[][] grid, int local, List<Integer> threatRegion, List<Integer> virusRegion, boolean[][] visited) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<Integer> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        queue.offer(local);
        virusRegion.add(local);
        visited[local / n][local % n] = true;
        int wall = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int x = node / n;
            int y = node % n;
            for (int i = 0; i < 4; i++) {
                int xx = x + dir[i][0];
                int yy = y + dir[i][1];
                if (xx < m && xx >= 0 && yy < n && yy >= 0 && !visited[xx][yy]) {
                    int newLocal = xx * n + yy;
                    if (grid[xx][yy] == 1) {
                        visited[xx][yy] = true;
                        virusRegion.add(newLocal);
                        queue.offer(newLocal);
                    } else if (grid[xx][yy] == 0) {
                        wall++;
                        if (!threatRegion.contains(newLocal))
                            threatRegion.add(newLocal);
                    }
                }
            }
        }
        return wall;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[][] grid={{0,1,0,0,0,0,0,1},
//                {0,1,0,0,0,0,0,1},
//                {0,0,0,0,0,0,0,1},
//                {0,0,0,0,0,0,0,0}};
        int[][] grid = {{0, 1, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 1}};
        int result = sol.containVirus(grid);
        System.out.println(result);
    }
}
